package com.learn.desgin.lld.parkinglot.model.vehicle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
public class Vehicle {
	private String vehicleNumber;
	private VehicleType vehicleType;
}
