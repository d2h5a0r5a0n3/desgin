package com.learn.desgin.pattern.strategy.solution.strategy;

import com.learn.desgin.pattern.strategy.solution.AbstractFileProcessingStrategy;
import org.springframework.stereotype.Component;

@Component("TXT")
public class TextProcessingStrategy extends AbstractFileProcessingStrategy {
    public TextProcessingStrategy() {
        System.out.println("TXT Bean Created"); // 👈 BREAKPOINT HERE
    }
    @Override
    protected void doProcess(String file) {
        System.out.println("Parsing TXT file");
    }
}
