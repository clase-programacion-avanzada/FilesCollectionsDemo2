package com.company.model;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

public class Producer implements Serializable {

    private static Long nextId = 1L;
    private Long id;
    private String name;
    private String country;
    private String nickName;
    private final List<Content> producedContents;

    public Producer(
                     String name,
                     String country,
                     String nickName) {
        this.id = getNextId();
        this.name = name;
        this.country = country;
        this.nickName = nickName;
        this.producedContents = new ArrayList<Content>();
    }

    private static synchronized Long getNextId() {
        return nextId++;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public List<Content> getProducedContents() {
        return producedContents;
    }


    public void addContent(Content content) {

        this.producedContents.add(content);
    }

    public boolean removeSong(Long songId) {
        for (Content content : producedContents) {
            if (content.getId().equals(songId)) {
                producedContents.remove(content);
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "Producer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", nickName='" + nickName + '\'' +

                '}';
    }
}


