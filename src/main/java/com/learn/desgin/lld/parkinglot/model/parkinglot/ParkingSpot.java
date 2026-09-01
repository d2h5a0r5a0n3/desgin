package com.learn.desgin.lld.parkinglot.model.parkinglot;

import com.learn.desgin.lld.parkinglot.model.vehicle.Vehicle;
import com.learn.desgin.lld.parkinglot.model.vehicle.VehicleType;
import lombok.*;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class ParkingSpot {
    private UUID spotId;
    private Long spotNumber;
    private VehicleType type;
    private Vehicle vehicle;
    private Boolean isAvailable = true;
}
