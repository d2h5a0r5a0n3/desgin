package com.learn.desgin.lld.parkinglot.service;


import com.learn.desgin.lld.parkinglot.model.parkinglot.AvailableSpot;
import com.learn.desgin.lld.parkinglot.model.parkinglot.ParkingLot;
import com.learn.desgin.lld.parkinglot.model.parkinglot.ParkingSpot;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingLotQueryService {
    private final ParkingLot parkingLot;

    public List<AvailableSpot> getAvailableSpots() {
        return parkingLot.getFloors().stream()
                .flatMap(parkingFloor -> parkingFloor.getSpots().stream()
                        .filter(ParkingSpot::getIsAvailable)
                        .map(spot -> new AvailableSpot(parkingFloor.getFloorNumber(),spot))
                )
                .toList();
    }
}
