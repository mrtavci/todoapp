
package com.hepsiemlak.todoapp.model;


import com.couchbase.client.java.repository.annotation.Field;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Document
@ApiModel(value = "User Document Object")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private Integer id;

    @NotNull
    @Field
    private String name;

    @Field
    private String surname;

    @Field
    private String mail;

    @Field
    @JsonIgnore
    private List<TaskModel> taskList = new ArrayList<>();

    public static class Builder{
        private String name;
        private String surname;
        private String mail;
        private List<TaskModel> todoList = new ArrayList<>();

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder mail(String mail) {
            this.mail = mail;
            return this;
        }

        public Builder todoList(List todoList) {
            this.todoList = todoList;
            return this;
        }

        public UserModel build() {
            UserModel user = new UserModel();
            user.setName(name);
            user.setSurname(surname);
            user.setMail(mail);
            user.setTaskList(todoList);
            return user;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", mail='" + mail + '\'' +
                    ", todoList=" + todoList +
                    '}';
        }
    }
    //region Getter Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<TaskModel> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<TaskModel> taskList) {
        this.taskList = taskList;
    }
    //endregion
}