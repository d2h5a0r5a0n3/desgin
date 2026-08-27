package com.learn.test.controller;

import lombok.RequiredArgsConstructor;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/process")
public class ProcessController {
    private final RuntimeService runtimeService;

    @PostMapping("/start")
    public String start(@RequestParam String user){
        Map<String,Object> vars = new HashMap<>();
        vars.put("initiator",user);
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("userRegistrationProcess",vars);
        return instance.getId();
    }
}
