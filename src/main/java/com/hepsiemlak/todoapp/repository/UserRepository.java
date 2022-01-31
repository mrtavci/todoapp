package com.hepsiemlak.todoapp.repository;


import com.hepsiemlak.todoapp.model.UserModel;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CouchbaseRepository<UserModel, Integer> {
}
