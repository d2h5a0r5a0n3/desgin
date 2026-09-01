package com.learn.desgin.lld.parkinglot.config;

import com.learn.desgin.lld.parkinglot.model.gate.EntryGate;
import com.learn.desgin.lld.parkinglot.model.gate.ExitGate;
import com.learn.desgin.lld.parkinglot.model.parkinglot.ParkingFloor;
import com.learn.desgin.lld.parkinglot.model.parkinglot.ParkingLot;
import com.learn.desgin.lld.parkinglot.model.parkinglot.ParkingSpot;
import com.learn.desgin.lld.parkinglot.model.vehicle.VehicleType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Configuration
public class ParkingLotInitConfig {
    @Bean
    public ParkingLot parkingLot() {
        List<ParkingFloor> floors = floors();
        List<EntryGate> entryGates = entryGates();
        List<ExitGate> exitGates = exitGates();
        return new ParkingLot(floors, entryGates, exitGates);
    }

    private List<ParkingFloor> floors() {
        List<ParkingFloor> floors = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            List<ParkingSpot> spots = new ArrayList<>();
            spots.addAll(spots(10, VehicleType.BIKE));
            spots.addAll(spots(5, VehicleType.CAR));
            spots.addAll(spots(3, VehicleType.TRUCK));
            floors.add(new ParkingFloor((long) i, spots));
        }
        return floors;
    }

    private List<ParkingSpot> spots(int n, VehicleType type) {
        List<ParkingSpot> spots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ParkingSpot spot = new ParkingSpot(UUID.randomUUID(), (long) i, type, null, true);
            spots.add(spot);
        }
        return spots;
    }

    private List<EntryGate> entryGates() {
        List<EntryGate> gates = new ArrayList<>();
        gates.add(new EntryGate(1L));
        gates.add(new EntryGate(2L));
        gates.add(new EntryGate(3L));
        gates.add(new EntryGate(4L));
        return gates;
    }

    private List<ExitGate> exitGates() {
        List<ExitGate> gates = new ArrayList<>();
        gates.add(new ExitGate(1L));
        gates.add(new ExitGate(2L));
        gates.add(new ExitGate(3L));
        gates.add(new ExitGate(4L));
        return gates;
    }
}
