package com.learn.desgin.lld.parkinglot.model.parkinglot;

import com.learn.desgin.lld.parkinglot.model.gate.EntryGate;
import com.learn.desgin.lld.parkinglot.model.gate.ExitGate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
@AllArgsConstructor
public class ParkingLot {
	private List<ParkingFloor> floors;
	private List<EntryGate> entryGates;
	private List<ExitGate> exitGates;
}
