package com.learn.desgin.parkinglot.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class ParkingSpot {
	private UUID spotId;
	private Long spotNumber;
	private VehicleType type;
	private Boolean isAvailable = true;
}
