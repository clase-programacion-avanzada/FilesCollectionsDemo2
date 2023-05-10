package com.company.inheritance.example;

public class ChildClass1 extends Parent {

    Integer myInteger;
    public ChildClass1(String userName, String name) {
        super(userName, name);
        this.myInteger = 0;

    }

    public void myMethod(){

    }

    @Override
    public String callingFrom() {

        return this.firstString() + "ChildClass1";
    }

    @Override
    public String toString() {
        return "ChildClass1{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", myList=" + myList +
                ", mySet=" + mySet +
                '}';
    }
}
