package com.hepsiemlak.todoapp.repository;


import com.hepsiemlak.todoapp.model.TaskModel;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CouchbaseRepository<TaskModel, Integer> {
}
