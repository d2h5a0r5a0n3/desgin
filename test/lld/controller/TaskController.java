package com.learn.test.controller;

import lombok.RequiredArgsConstructor;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/tasks")
    public List<Map<String,String>> tasks(){

        return taskService.createTaskQuery()
                .list()
                .stream()
                .map(t -> Map.of(
                        "taskId", t.getId(),
                        "name", t.getName(),
                        "assignee", String.valueOf(t.getAssignee()),
                        "processId", t.getProcessInstanceId()
                ))
                .toList();
    }

    @GetMapping("/{processId}")
    public List<Task> tasks(@PathVariable String processId) {
        return taskService.createTaskQuery()
                .processInstanceId(processId)
                .list();
    }

    @PostMapping("/complete/{taskId}")
    public String complete(@PathVariable String taskId,@RequestBody(required = false) Map<String,Object> vars){
        taskService.complete(taskId,vars == null ? new HashMap<>():vars);
        return "task completed";
    }
}
