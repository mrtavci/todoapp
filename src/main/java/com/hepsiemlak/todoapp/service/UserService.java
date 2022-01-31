package com.hepsiemlak.todoapp.service;

import com.hepsiemlak.todoapp.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserModel save(UserModel model);

    UserModel update(Integer id,UserModel model);

    Optional<UserModel> findById(Integer id);

    void deleteById(Integer id);

    List<UserModel> findAll();
}
