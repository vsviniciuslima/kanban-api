package com.looplex.kanbanapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.looplex.kanbanapi.model.Task;
import com.looplex.kanbanapi.model.paging.TaskPage;
import com.looplex.kanbanapi.repository.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public Page<Task> getTasks(TaskPage taskPage) {
        Sort sort = Sort.by(taskPage.getSortDirection(), taskPage.getSortBy());
        Pageable pageable = PageRequest.of(taskPage.getPageNumber(), taskPage.getPageSize(), sort);
        return taskPage.getStatus() == null ? taskRepository.findAll(pageable) : taskRepository.findByStatus(taskPage.getStatus(), pageable);
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Long removeTask(Long id) {
        this.taskRepository.deleteById(id);
        return id;
    }

    public ResponseEntity<Task> updateTask(String stringId, JsonPatch patch) {
        Long id = Long.parseLong(stringId);
        try {
            Task task = taskRepository.findById(id).orElseThrow(NullPointerException::new);
            Task taskPatched = applyPatchToCustomer(patch, task);
            //customerService.updateCustomer(taskPatched);
            return ResponseEntity.ok(taskPatched);
        } catch (JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    private Task applyPatchToCustomer(
            JsonPatch patch, Task targetTask) throws JsonPatchException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode patched = patch.apply(objectMapper.convertValue(targetTask, JsonNode.class));
        return objectMapper.treeToValue(patched, Task.class);
    }
}
