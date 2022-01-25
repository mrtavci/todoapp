package com.hepsiemlak.todoapp.repository;


import com.hepsiemlak.todoapp.model.UserModel;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

import java.util.List;

@ViewIndexed(designDoc="user")
public interface UserRepository extends CouchbaseRepository<UserModel, String> {
    @Query("#{#n1ql.selectEntity}")
    List<UserModel> findAll();
}
