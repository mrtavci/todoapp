package com.hepsiemlak.todoapp.repository;


import com.hepsiemlak.todoapp.model.TaskModel;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

import java.util.List;

@ViewIndexed(designDoc="task")
public interface TaskRepository extends CouchbaseRepository<TaskModel, String> {
    @Query("#{#n1ql.selectEntity}")
    List<TaskModel> findAll();
}
