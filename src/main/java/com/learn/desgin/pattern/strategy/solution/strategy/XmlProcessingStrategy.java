package com.learn.desgin.pattern.strategy.solution.strategy;

import com.learn.desgin.pattern.strategy.solution.AbstractFileProcessingStrategy;
import org.springframework.stereotype.Component;

@Component("XML")
public class XmlProcessingStrategy extends AbstractFileProcessingStrategy {

    public XmlProcessingStrategy() {
        System.out.println("XML Bean Created"); // 👈 BREAKPOINT HERE
    }
    @Override
    protected void doProcess(String file) {
        System.out.println("Parsing XML file");
    }
}
