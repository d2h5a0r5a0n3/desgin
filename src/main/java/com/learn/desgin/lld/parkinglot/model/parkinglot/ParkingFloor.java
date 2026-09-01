package com.learn.desgin.lld.parkinglot.model.parkinglot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ParkingFloor {
    private Long floorNumber;
    private List<ParkingSpot> spots;
}
