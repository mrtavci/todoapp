package com.hepsiemlak.todoapp.controller;

import com.hepsiemlak.todoapp.model.UserModel;
import com.hepsiemlak.todoapp.service.impl.UserServiceImpl;
import com.hepsiemlak.todoapp.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(ApiPaths.UserCtrl.CTRL)
@Api(value = "User APIS")
public class User {

    final UserServiceImpl serviceImpl;

    public User(UserServiceImpl serviceImpl) {
        this.serviceImpl = serviceImpl;
    }

    @PostMapping
    @ApiOperation(value = "Create Operation", response = UserModel.class)
    public UserModel saveUser(@RequestBody UserModel newUser) {
        return serviceImpl.save(newUser);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation", response = UserModel.class)
    public UserModel update(@PathVariable String id, @RequestBody UserModel updateUser) {
        return serviceImpl.update(id, updateUser);
    }

    @ApiOperation(value = "Delete By Id Operation")
    @DeleteMapping("/user/{id}")
    public void deleteById(@PathVariable String id) {
        serviceImpl.deleteById(id);
    }

    @ApiOperation(value = "Get All Records")
    @GetMapping
    public List<UserModel> findUsers() {
        return serviceImpl.findAll();
    }

    @ApiOperation(value = "Get By Id Operation", response = UserModel.class)
    @GetMapping("/{id}")
    public Optional<UserModel> findById(@PathVariable String id) {
        return serviceImpl.findById(id);
    }
}
