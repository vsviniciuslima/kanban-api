package com.looplex.kanbanapi.service;

import com.looplex.kanbanapi.model.Task;
import com.looplex.kanbanapi.model.paging.TaskPage;
import com.looplex.kanbanapi.repository.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public Page<Task> getTasks(TaskPage taskPage) {

        Sort sort = Sort.by(taskPage.getSortDirection(), taskPage.getSortBy());
        Pageable pageable = PageRequest.of(taskPage.getPageNumber(),
                taskPage.getPageSize(), sort);
        if(taskPage.getFilterArgument() != null) {
            return taskRepository.filterByStatus(taskPage.getFilterArgument(), pageable);
        }
        return taskRepository.findAll(pageable);
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
}
