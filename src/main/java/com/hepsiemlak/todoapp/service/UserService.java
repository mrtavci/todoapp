package com.hepsiemlak.todoapp.service;

import com.hepsiemlak.todoapp.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserModel save(UserModel model);

    UserModel update(String id,UserModel model);

    Optional<UserModel> findById(String id);

    void deleteById(String id);

    List<UserModel> findAll();
}
