package com.learn.desgin.pattern.strategy.solution;

public abstract class AbstractFileProcessingStrategy implements FileProcessStrategy{
    @Override
    public void process(String file){
        validate(file);
        logStart(file);
        doProcess(file);
        logEnd(file);
    }

    private void validate(String file){
        if(file == null || file.isEmpty()){
            throw new IllegalArgumentException("File cannot be empty");
        }
    }

    private void logStart(String file) {
        System.out.println("Starting processing: " + file);
    }

    protected abstract void doProcess(String file);

    private void logEnd(String file) {
        System.out.println("Finished processing: " + file);
    }
}
