package com.learn.desgin.parkinglot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Ticket {
	private UUID id;
	private Vehicle vehicle;
	private Long floorNumber;
	private Long spotNumber;
	private LocalDateTime createdAt;
	private LocalDateTime exitAt;
	private Boolean isClosed = false;
	private Payment payment;
}
