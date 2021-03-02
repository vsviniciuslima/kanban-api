package com.looplex.kanbanapi.controller;

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


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    /*
    @GetMapping("/employees")
    public CollectionModel<EntityModel<Task>> all() {

        List<EntityModel<Task>> tasks = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(tasks, linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
    }*/
}
