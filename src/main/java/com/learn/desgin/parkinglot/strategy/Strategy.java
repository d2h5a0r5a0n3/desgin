package com.learn.desgin.parkinglot.strategy;

import com.learn.desgin.parkinglot.model.Price;
import com.learn.desgin.parkinglot.model.Ticket;
import com.learn.desgin.parkinglot.model.Vehicle;

public interface Strategy {
	Price calculateFee();
	Ticket parkVehicle(Vehicle vehicle);
	Ticket unParkVehicle();
}
