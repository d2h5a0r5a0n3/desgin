package com.learn.desgin.lld.parkinglot.model.ticket;

import com.learn.desgin.lld.parkinglot.model.gate.ExitGate;
import com.learn.desgin.lld.parkinglot.model.payment.Payment;
import com.learn.desgin.lld.parkinglot.model.payment.Price;
import com.learn.desgin.lld.parkinglot.model.vehicle.Vehicle;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class ExitTicket extends Ticket {
    private ExitGate exitGate;
    private LocalDateTime exitAt;
    private Boolean isClosed = false;
    private Price price;
    private Payment payment;

    public ExitTicket(UUID id, Vehicle vehicle, Long floorNumber, Long spotNumber) {
        super(id, vehicle, floorNumber, spotNumber);
    }
}
