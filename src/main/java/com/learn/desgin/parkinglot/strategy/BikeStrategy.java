package com.learn.desgin.parkinglot.strategy;

import com.learn.desgin.parkinglot.model.Price;
import com.learn.desgin.parkinglot.model.Ticket;
import com.learn.desgin.parkinglot.model.Vehicle;
import com.learn.desgin.parkinglot.service.ParkingLotQueryService;
import org.springframework.stereotype.Component;

@Component
public class BikeStrategy extends AbstractStrategy{
	public BikeStrategy(ParkingLotQueryService queryService) {
		super(queryService);
	}

	@Override
	public Price calculateFee() {
		return null;
	}

	@Override
	public Ticket parkVehicle(Vehicle vehicle) {
		queryService.
		return null;
	}

	@Override
	public Ticket unParkVehicle() {
		return null;
	}
}
