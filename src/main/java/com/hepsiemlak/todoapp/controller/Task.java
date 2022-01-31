package com.hepsiemlak.todoapp.controller;

import com.hepsiemlak.todoapp.model.TaskModel;
import com.hepsiemlak.todoapp.service.impl.TaskServiceImpl;
import com.hepsiemlak.todoapp.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(ApiPaths.TaskCtrl.CTRL)
@Api(value = "Task APIS")
public class Task {

    final TaskServiceImpl serviceImpl;

    public Task(TaskServiceImpl serviceImpl) {
        this.serviceImpl = serviceImpl;
    }

    @PostMapping
    @ApiOperation(value = "Create Operation", response = TaskModel.class)
    public TaskModel saveTask(@RequestBody TaskModel newTask) {
        return serviceImpl.save(newTask);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation", response = TaskModel.class)
    public TaskModel update(@PathVariable Integer id, @RequestBody TaskModel updateTask) {
        return serviceImpl.update(id, updateTask);
    }

    @ApiOperation(value = "Delete By Id Operation")
    @DeleteMapping("/task/{id}")
    public void deleteById(@PathVariable Integer id) {
        serviceImpl.deleteById(id);
    }

    @ApiOperation(value = "Get All Records")
    @GetMapping
    public List<TaskModel> findTasks() {
        return serviceImpl.findAll();
    }

    @ApiOperation(value = "Get By Id Operation", response = TaskModel.class)
    @GetMapping("/{id}")
    public Optional<TaskModel> findById(@PathVariable Integer id) {
        return serviceImpl.findById(id);
    }
}
