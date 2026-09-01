package com.learn.desgin.lld.parkinglot.strategy.impl;

import com.learn.desgin.lld.parkinglot.model.payment.Price;
import com.learn.desgin.lld.parkinglot.model.vehicle.VehicleType;
import com.learn.desgin.lld.parkinglot.service.ParkingLotQueryService;
import com.learn.desgin.lld.parkinglot.strategy.AbstractStrategy;
import org.springframework.stereotype.Component;

@Component
public class BikeStrategy extends AbstractStrategy {
    public BikeStrategy(ParkingLotQueryService queryService) {
        super(queryService);
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.BIKE;
    }


    @Override
    public boolean canFit(VehicleType type) {
        return type == VehicleType.BIKE;
    }

    @Override
    public Price calculateFee() {
        return new Price(10f);
    }
}
