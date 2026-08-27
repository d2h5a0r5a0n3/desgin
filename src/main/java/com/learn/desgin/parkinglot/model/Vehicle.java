package com.learn.desgin.parkinglot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Vehicle {
	private String vehicleNumber;
	private VehicleType vehicleType;
}
