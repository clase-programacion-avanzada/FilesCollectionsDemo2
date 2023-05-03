package com.company.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Client  implements Serializable {
    private Long id;
    private String userName;
    private String password;
    private String name;
    private String lastName;
    private Integer age;


    private static long nextId = 1;

    public Client(String userName,
                  String password,
                  String name,
                  String lastName,
                  Integer age
                  ) {
        this.id = nextId++;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.age = age;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }



    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }


    public abstract boolean addContentToPlayList(Content content, Long playListId) ;



}
