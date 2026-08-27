package com.learn.desgin.parkinglot.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParkingFloor {
	private Long floorNumber;
	private List<ParkingSpot> spots;
}
