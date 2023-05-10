package com.company.inheritance.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InheritanceMainExample {
    public static void main(String[] args) {
        ParentCollection parentCollection = new ParentCollection();

        ChildClass1 child1 = new ChildClass1("userName","Name");

        List<Parent> parents =
                new ArrayList<>();

        parents.add(child1);

        //Parent parent1 = new Parent("userName1", "name");

       // parents.add(parent1);

        Parent child2 = new ChildClass2("userName","Name");

        parents.add(child2);

        parents.stream().forEach(p ->
                System.out.println(p.callingFrom())
        );

        for (Parent p : parents) {

            if (p instanceof ChildClass1) {

                ((ChildClass1) p).myMethod();
                System.out.println(p);
            }
            if (p instanceof  ChildClass2) {

            }

        }
        

    }
}
