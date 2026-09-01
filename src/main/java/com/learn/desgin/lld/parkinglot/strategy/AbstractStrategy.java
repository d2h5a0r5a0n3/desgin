package com.learn.desgin.lld.parkinglot.strategy;

import com.learn.desgin.lld.parkinglot.model.gate.ExitGate;
import com.learn.desgin.lld.parkinglot.model.parkinglot.AvailableSpot;
import com.learn.desgin.lld.parkinglot.model.parkinglot.ParkingSpot;
import com.learn.desgin.lld.parkinglot.model.payment.Payment;
import com.learn.desgin.lld.parkinglot.model.payment.Price;
import com.learn.desgin.lld.parkinglot.model.ticket.EntryTicket;
import com.learn.desgin.lld.parkinglot.model.ticket.ExitTicket;
import com.learn.desgin.lld.parkinglot.model.vehicle.Vehicle;
import com.learn.desgin.lld.parkinglot.model.vehicle.VehicleType;
import com.learn.desgin.lld.parkinglot.service.ParkingLotQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public abstract class AbstractStrategy implements Strategy {
    protected final ParkingLotQueryService queryService;

    public List<AvailableSpot> getAvailableSpots() {
        return queryService.getAvailableSpots().stream().filter(spot -> this.canFit(spot.spot().getType())).toList();
    }

    @Override
    public AvailableSpot park(Vehicle vehicle) {
        AvailableSpot availableSpot = getAvailableSpots().stream().findFirst().orElseThrow(() -> new RuntimeException("Parking spot not available"));
        availableSpot.spot().setIsAvailable(false);
        availableSpot.spot().setVehicle(vehicle);
        return availableSpot;
    }

    @Override
    public ExitTicket unPark(EntryTicket entryTicket, AvailableSpot spot, Payment payment, ExitGate exitGate) {
        spot.spot().setIsAvailable(true);
        spot.spot().setVehicle(null);

        LocalDateTime exitAt = LocalDateTime.now();
        Duration diff = Duration.between(exitAt,entryTicket.getCreatedAt());
        long minutes = diff.toMinutes() == 0 ? 5 : diff.toMinutes();
        Price price = new Price(calculateFee().price() * minutes / 60);

        ExitTicket exitTicket = new ExitTicket(
                entryTicket.getId(),
                entryTicket.getVehicle(),
                entryTicket.getFloorNumber(),
                entryTicket.getSpotNumber()
        );
        exitTicket.setIsClosed(true);
        exitTicket.setPayment(payment);
        exitTicket.setExitAt(LocalDateTime.now());
        exitTicket.setExitGate(exitGate);
        exitTicket.setPrice(price);

        return exitTicket;
    }
}
