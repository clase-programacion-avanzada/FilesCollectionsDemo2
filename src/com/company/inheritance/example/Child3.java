package com.company.inheritance.example;

public class Child3 extends Parent{


    public Child3(String userName, String name) {
        super(userName, name);
    }

    @Override
    public String callingFrom() {
        return null;
    }
}
