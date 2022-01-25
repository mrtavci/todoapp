package com.hepsiemlak.todoapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

import java.util.Collections;
import java.util.List;

@Configuration
public class Couchbase extends AbstractCouchbaseConfiguration {

    @Value("${couchbase.cluster.bucket}")
    private String bucketName;

    @Value("${couchbase.cluster.username}")
    private String username;

    @Value("${couchbase.cluster.password}")
    private String password;

    @Value("${couchbase.cluster.ip}")
    private String ip;


    @Override
    protected List<String> getBootstrapHosts() {
        return Collections.singletonList(this.ip);
    }

    @Override
    protected String getBucketName() {
        return this.bucketName;
    }

    @Override
    protected String getBucketPassword() {
        return this.password;
    }

    @Override
    protected String getUsername() {
        return this.username;
    }
}
