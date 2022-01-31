package com.hepsiemlak.todoapp.service;

import com.hepsiemlak.todoapp.model.TaskModel;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    TaskModel save(TaskModel model);

    TaskModel update(Integer id,TaskModel model);

    Optional<TaskModel> findById(Integer id);

    void deleteById(Integer id);

    List<TaskModel> findAll();
}
