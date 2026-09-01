package com.learn.desgin.lld.parkinglot.service;

import com.learn.desgin.lld.parkinglot.model.gate.EntryGate;
import com.learn.desgin.lld.parkinglot.model.gate.ExitGate;
import com.learn.desgin.lld.parkinglot.model.parkinglot.AvailableSpot;
import com.learn.desgin.lld.parkinglot.model.parkinglot.ParkingLot;
import com.learn.desgin.lld.parkinglot.model.parkinglot.ParkingSpot;
import com.learn.desgin.lld.parkinglot.model.payment.Payment;
import com.learn.desgin.lld.parkinglot.model.ticket.EntryTicket;
import com.learn.desgin.lld.parkinglot.model.ticket.ExitTicket;
import com.learn.desgin.lld.parkinglot.model.vehicle.Vehicle;
import com.learn.desgin.lld.parkinglot.strategy.Strategy;
import com.learn.desgin.lld.parkinglot.strategy.StrategyFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ParkingLotService {
    private final StrategyFactory strategyFactory;
    private final Map<UUID, AvailableSpot> ticketSpot;
    private final TicketService ticketService;

    public EntryTicket park(Vehicle vehicle, EntryGate entryGate) {
        Strategy strategy = strategyFactory.getStrategy(vehicle.getVehicleType());
        AvailableSpot spot = strategy.park(vehicle);
        EntryTicket entryTicket = new EntryTicket(
                UUID.randomUUID(),
                vehicle,
                spot.floorNumber(),
                spot.spot().getSpotNumber()
        );
        entryTicket.setCreatedAt(LocalDateTime.now());
        entryTicket.setGate(entryGate);
        ticketService.add(entryTicket);
        ticketSpot.put(entryTicket.getId(), spot);
        return entryTicket;
    }

    public ExitTicket unPark(UUID entryTicketId, Payment payment, ExitGate exitGate) {
        EntryTicket entryTicket = ticketService.get(entryTicketId);
        Strategy strategy = strategyFactory.getStrategy(entryTicket.getVehicle().getVehicleType());
        return strategy.unPark(entryTicket, ticketSpot.remove(entryTicket.getId()), payment, exitGate);
    }
}
