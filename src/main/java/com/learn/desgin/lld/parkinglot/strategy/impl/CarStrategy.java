package com.learn.desgin.lld.parkinglot.strategy.impl;

import com.learn.desgin.lld.parkinglot.model.payment.Price;
import com.learn.desgin.lld.parkinglot.model.vehicle.VehicleType;
import com.learn.desgin.lld.parkinglot.service.ParkingLotQueryService;
import com.learn.desgin.lld.parkinglot.strategy.AbstractStrategy;
import org.springframework.stereotype.Component;

@Component
public class CarStrategy extends AbstractStrategy {
    public CarStrategy(ParkingLotQueryService queryService) {
        super(queryService);
    }

    @Override
    public Price calculateFee() {
        return new Price(20f);
    }

@Override
    public VehicleType getVehicleType() {
        return VehicleType.CAR;
    }

    @Override
    public boolean canFit(VehicleType type) {
        return type == VehicleType.CAR || type == VehicleType.TRUCK;
    }
}
