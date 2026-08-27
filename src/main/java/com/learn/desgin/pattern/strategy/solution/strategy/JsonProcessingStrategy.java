package com.learn.desgin.pattern.strategy.solution.strategy;

import com.learn.desgin.pattern.strategy.solution.AbstractFileProcessingStrategy;
import org.springframework.stereotype.Component;

@Component("JSON")
public class JsonProcessingStrategy extends AbstractFileProcessingStrategy {

    public JsonProcessingStrategy() {
        System.out.println("JSON Bean Created"); // 👈 BREAKPOINT HERE
    }
    @Override
    protected void doProcess(String file) {
        System.out.println("Parsing JSON file");
    }
}
