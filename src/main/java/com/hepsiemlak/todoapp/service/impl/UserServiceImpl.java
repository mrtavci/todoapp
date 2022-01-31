package com.hepsiemlak.todoapp.service.impl;

import com.hepsiemlak.todoapp.model.UserModel;
import com.hepsiemlak.todoapp.repository.UserRepository;
import com.hepsiemlak.todoapp.repository.UserRepository;
import com.hepsiemlak.todoapp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserModel save(UserModel taskModel) {
        return repository.save(taskModel);
    }

    @Override
    public UserModel update(Integer id, UserModel model) {
        UserModel taskData = repository.findById(id).orElseThrow(IllegalArgumentException::new);
        if (taskData == null) {
            throw new IllegalArgumentException("User Does Not Exist Id:" + id);
        }
        return repository.save(model);
    }

    @Override
    public Optional<UserModel> findById(Integer id) {
        if (repository.existsById(id)) {
            return repository.findById(id);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<UserModel> findAll() {
        return repository.findAll();
    }


}
