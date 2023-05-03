package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class PlayList {

    private static Long nextId = 1L;

    private Long id;
    private String name;
    private  List<Content> contents;
    public PlayList() {
        this.id = nextId++;
        this.name = "";
        this.contents = new ArrayList<>();
    }

    public PlayList(String name) {

        this.id = nextId++;
        this.name = name;
        this.contents = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void addContent(Content content) {
        this.contents.add(content);
    }
}
