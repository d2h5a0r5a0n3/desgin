package com.learn.desgin.lld.parkinglot.model.ticket;

import com.learn.desgin.lld.parkinglot.model.gate.EntryGate;
import com.learn.desgin.lld.parkinglot.model.vehicle.Vehicle;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class EntryTicket extends Ticket {
    private LocalDateTime createdAt;
    private EntryGate gate;

	public EntryTicket(UUID id, Vehicle vehicle, Long floorNumber, Long spotNumber) {
		super(id, vehicle, floorNumber, spotNumber);
	}
}
