package com.learn.desgin.pattern.strategy.solution.controller;

import com.learn.desgin.pattern.strategy.solution.service.FileProcessingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/files")
public class FileProcessingController {
    private final FileProcessingService service;

    public FileProcessingController(FileProcessingService service) {
        this.service = service;
    }

    @GetMapping("/process")
    public String process(@RequestParam String type, @RequestParam String file) {
        service.process(type, file);
        return "Processed successfully";
    }
}