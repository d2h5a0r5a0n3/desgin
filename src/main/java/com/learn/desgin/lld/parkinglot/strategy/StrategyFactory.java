package com.learn.desgin.lld.parkinglot.strategy;

import com.learn.desgin.lld.parkinglot.model.vehicle.VehicleType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class StrategyFactory {
    private final Map<VehicleType, Strategy> strategies;

    public StrategyFactory(List<Strategy> strategyList) {
        this.strategies = strategyList.stream().collect(
                Collectors.toMap(
                        Strategy::getVehicleType,
                        Function.identity()
                )
        );
    }

    public Strategy getStrategy(VehicleType vehicleType) {
        Strategy strategy = strategies.get(vehicleType);
        if (strategy == null) {
            throw new IllegalArgumentException(
                    "Unsupported vehicle type: " + vehicleType
            );
        }
        return strategy;
    }
}
