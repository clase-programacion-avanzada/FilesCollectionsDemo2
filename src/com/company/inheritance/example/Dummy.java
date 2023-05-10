package com.company.inheritance.example;

public class Dummy {

    private static int nextId = 1;
    private int id;

    private String userName;
    private String dummyAttribute;
    private String anotherAttribute;

    public Dummy(String userName, String dummyAttribute, String anotherAttribute) {
        this.userName = userName;
        this.id = nextId++;
        this.dummyAttribute = dummyAttribute;
        this.anotherAttribute = anotherAttribute;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDummyAttribute() {
        return dummyAttribute;
    }

    public void setDummyAttribute(String dummyAttribute) {
        this.dummyAttribute = dummyAttribute;
    }

    public String getAnotherAttribute() {
        return anotherAttribute;
    }

    public void setAnotherAttribute(String anotherAttribute) {
        this.anotherAttribute = anotherAttribute;
    }
}
