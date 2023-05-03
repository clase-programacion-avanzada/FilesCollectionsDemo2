package com.company.model;

public class Podcast extends Content {
    private String author;
    private String category;

    public Podcast(String name, Integer duration, String author, String category) {
        super(name, duration);
        this.author = author;
        this.category = category;


    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void play(){
        System.out.println("Playing podcast "+ this.name);
    }
}
