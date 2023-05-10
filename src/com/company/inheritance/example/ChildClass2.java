package com.company.inheritance.example;

public class ChildClass2 extends Parent {


    public ChildClass2(String userName, String name) {
        super(userName, name);
    }

    @Override
    public String callingFrom() {

        return this.firstString() + "ChildClass2";
    }

    public void myMethod2(){

    }
}
