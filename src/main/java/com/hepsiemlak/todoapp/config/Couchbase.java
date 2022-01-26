package com.hepsiemlak.todoapp.config;

import com.couchbase.client.java.Bucket;
import com.hepsiemlak.todoapp.model.UserModel;
import jdk.nashorn.internal.runtime.options.LoggingOption;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractReactiveCouchbaseConfiguration;
import org.springframework.data.couchbase.core.RxJavaCouchbaseTemplate;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.data.couchbase.repository.config.ReactiveRepositoryOperationsMapping;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@Configuration
@EnableCouchbaseRepositories
public class Couchbase extends AbstractReactiveCouchbaseConfiguration {

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

    private Bucket userAuthBucket() throws Exception {
        return couchbaseCluster().openBucket("user");
    }

    private RxJavaCouchbaseTemplate userAuthTemplate() throws Exception {
        RxJavaCouchbaseTemplate template = new RxJavaCouchbaseTemplate(
                couchbaseClusterInfo(), userAuthBucket(),
                mappingCouchbaseConverter(), translationService());
        template.setDefaultConsistency(getDefaultConsistency());
        return template;
    }

    @Override
    public void configureReactiveRepositoryOperationsMapping(ReactiveRepositoryOperationsMapping baseMapping) {
        try {
            baseMapping.mapEntity(UserModel.class, userAuthTemplate());
        } catch (Exception ex) {
            Logger.getAnonymousLogger().info("Error in creating mapping for {} bucket" + this.username + ex);
        }
    }
}
