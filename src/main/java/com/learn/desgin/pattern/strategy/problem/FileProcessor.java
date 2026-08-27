package com.learn.desgin.pattern.strategy.problem;

public class FileProcessor {
    public void process(String type, String file) {
        switch (type) {
            case "csv" -> System.out.println("Processing the csv file");
            case "txt" -> System.out.println("Processing the txt file");
            case "json" -> System.out.println("Processing the json file");
            case "xml" -> System.out.println("Processing the xml file");
            default -> System.out.println("Unsupported file type");
            //this if-else grows as new type adds
            //and also break the OCD principle (open for extension and closed for edit) principle
        }
    }
}
