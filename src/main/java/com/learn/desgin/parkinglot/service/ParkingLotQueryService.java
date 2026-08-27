package com.learn.desgin.parkinglot.service;

import com.learn.desgin.parkinglot.model.ParkingLot;
import com.learn.desgin.parkinglot.model.ParkingSpot;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotQueryService {
	private ParkingLot parkingLot;

	public List<ParkingSpot> getAvailableSpots(){
		return parkingLot.getFloors().stream()
				.flatMap(parkingFloor -> parkingFloor.getSpots().stream())
				.filter(ParkingSpot::getIsAvailable)
				.toList();
	}
}
