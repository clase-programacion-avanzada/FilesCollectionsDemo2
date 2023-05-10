package com.company.inheritance.example;

public class ChildClass1 extends Parent{

    public ChildClass1(String userName, String name) {
        super(userName, name);
    }

    @Override
    public String callingFrom() {

        return this.firstString() + "ChildClass1";
    }
}
