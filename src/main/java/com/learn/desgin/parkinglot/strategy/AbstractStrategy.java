package com.learn.desgin.parkinglot.strategy;

import com.learn.desgin.parkinglot.service.ParkingLotQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public abstract class AbstractStrategy implements Strategy{
	protected final ParkingLotQueryService queryService;
}
