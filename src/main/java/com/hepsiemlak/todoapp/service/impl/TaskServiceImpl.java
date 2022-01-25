package com.hepsiemlak.todoapp.service.impl;

import com.hepsiemlak.todoapp.model.TaskModel;
import com.hepsiemlak.todoapp.repository.TaskRepository;
import com.hepsiemlak.todoapp.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public TaskModel save(TaskModel taskModel) {
        return repository.save(taskModel);
    }

    @Override
    public TaskModel update(String id, TaskModel model) {
        TaskModel taskData = repository.findById(id).orElseThrow(IllegalArgumentException::new);
        if (taskData == null) {
            throw new IllegalArgumentException("Task Does Not Exist Id:" + id);
        }
        return repository.save(model);
    }

    @Override
    public Optional<TaskModel> findById(String id) {
        if (repository.existsById(id)) {
            return repository.findById(id);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<TaskModel> findAll() {
        return repository.findAll();
    }


}
