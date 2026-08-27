package com.learn.desgin.pattern.strategy.solution.service;

import com.learn.desgin.pattern.strategy.solution.FileProcessStrategy;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class FileProcessingService {
    private final Map<String, FileProcessStrategy> strategyMap;

    public FileProcessingService(Map<String, FileProcessStrategy> map) {
        this.strategyMap = map;
    }

    public void process(String type, String file) {
        FileProcessStrategy strategy = Optional
                .ofNullable(strategyMap.get(type))
                .orElseThrow(() -> new IllegalArgumentException("Unsupported type: " + type));
        strategy.process(file);
    }
}
