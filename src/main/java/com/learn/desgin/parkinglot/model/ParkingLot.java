package com.learn.desgin.parkinglot.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public class ParkingLot {
	private List<ParkingFloor> floors;
	private List<EntryGate> entryGates;
	private List<ExitGate> exitGates;
}
