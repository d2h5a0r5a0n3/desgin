package com.learn.desgin.pattern.strategy.solution.strategy;

import com.learn.desgin.pattern.strategy.solution.AbstractFileProcessingStrategy;
import org.springframework.stereotype.Component;

@Component("CSV")
public class CsvProcessingStrategy extends AbstractFileProcessingStrategy {

    public CsvProcessingStrategy() {
        System.out.println("CSV Bean Created"); // 👈 BREAKPOINT HERE
    }
    @Override
    protected void doProcess(String file) {
        System.out.println("Parsing CSV file");
    }
}
