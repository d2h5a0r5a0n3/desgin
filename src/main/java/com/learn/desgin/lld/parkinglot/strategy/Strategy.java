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

import java.util.List;

public interface Strategy {
    boolean canFit(VehicleType type);

    Price calculateFee();

    List<AvailableSpot> getAvailableSpots();

    VehicleType getVehicleType();

    AvailableSpot park(Vehicle vehicle);

    ExitTicket unPark(EntryTicket entryTicket, AvailableSpot spot, Payment payment, ExitGate exitGate);
}
