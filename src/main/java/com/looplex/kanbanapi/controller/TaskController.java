package com.looplex.kanbanapi.controller;

import com.github.fge.jsonpatch.JsonPatch;
import com.looplex.kanbanapi.model.Task;
import com.looplex.kanbanapi.model.paging.TaskPage;
import com.looplex.kanbanapi.service.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskService taskService;

    @GetMapping
    public ResponseEntity<Page<Task>> getTasks(TaskPage taskPage) {
        return new ResponseEntity<>(taskService.getTasks(taskPage), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        return new ResponseEntity<>(taskService.addTask(task), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteTask(@PathVariable Long id) {
        return new ResponseEntity<>(taskService.removeTask(id), HttpStatus.OK);
    }

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PatchMapping(path = "/{id}", consumes = "application/json-patch+json")
    public ResponseEntity<Task> updateTask(@PathVariable String id, @RequestBody JsonPatch patch) {
        return taskService.updateTask(id, patch);
    }
}
