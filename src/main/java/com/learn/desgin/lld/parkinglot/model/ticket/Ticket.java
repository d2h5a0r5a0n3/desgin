package com.learn.desgin.lld.parkinglot.model.ticket;

import com.learn.desgin.lld.parkinglot.model.vehicle.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public abstract class Ticket {
    private UUID id;
    private Vehicle vehicle;
    private Long floorNumber;
    private Long spotNumber;
}
