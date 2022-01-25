package com.hepsiemlak.todoapp.service;

import com.hepsiemlak.todoapp.model.TaskModel;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    TaskModel save(TaskModel model);

    TaskModel update(String id,TaskModel model);

    Optional<TaskModel> findById(String id);

    void deleteById(String id);

    List<TaskModel> findAll();
}
