package com.company.inheritance.example;

import java.util.*;

public abstract class Parent {

    private static int nextId = 1;
    protected int id;
    protected String userName;
    protected String name;
    protected List<Dummy> myList;
    protected Set<Dummy> mySet;
    private Map<Integer,Dummy> mapByDummyId;
    private Map<String, Dummy> mapByDummyUsername;


    public Parent(String userName, String name) {
        this.id = nextId++;
        this.userName = userName;
        this.name = name;

        myList = new ArrayList<>();
        mySet = new HashSet<>();
        mapByDummyId = new HashMap<>();
        mapByDummyUsername = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getName() {
        return name;
    }

    public List<Dummy> getMyList() {
        return myList;
    }

    public Set<Dummy> getMySet() {
        return mySet;
    }

    public Map<Integer, Dummy> getMapByDummyId() {
        return mapByDummyId;
    }

    public Map<String, Dummy> getMapByDummyUsername() {
        return mapByDummyUsername;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addObjectToMySet(String userName,
                                 String dummyAttribute,
                                 String anotherAttribute) {
        Dummy dummyObject = new Dummy(userName,
                dummyAttribute,
                anotherAttribute);

        mySet.add(dummyObject);

    }

    public void addObjectToMyList(String userName,
                                  String dummyAttribute,
                                  String anotherAttribute) {
        Dummy dummyObject = new Dummy(userName,
                dummyAttribute,
                anotherAttribute);

        myList.add(dummyObject);

    }

    public void addObjectToMyMaps(String userName,
                                  String dummyAttribute,
                                  String anotherAttribute) {

        boolean userNameAlreadyExists =
                mapByDummyUsername.containsKey(userName);
        if (userNameAlreadyExists) {
            throw new IllegalArgumentException("Username is already in use in Dummy's map");
        }

        Dummy dummyObject = new Dummy(userName,
                dummyAttribute,
                anotherAttribute);

        mapByDummyId.put(dummyObject.getId(), dummyObject);
        mapByDummyUsername.put(dummyObject.getUserName(), dummyObject );

    }

    public List<Dummy> getListOfValuesFromMapById() {

        List<Dummy> dummiesList =
                mapByDummyId.values().stream().toList();

        List<Dummy> anotherDummyList = new ArrayList<>();
        for (Integer id : mapByDummyId.keySet()) {
            Dummy d = mapByDummyId.get(id);
            anotherDummyList.add(d);
        }

        for (Dummy d : mapByDummyId.values()) {
            anotherDummyList.add(d);
        }

        for (Map.Entry<Integer,Dummy> entry : mapByDummyId.entrySet()) {
            Integer id = entry.getKey();
            anotherDummyList.add(entry.getValue());
        }

        return dummiesList;

    }

    public List<Dummy> getListOfValuesFromMapByUsername() {

        List<Dummy> dummiesList = mapByDummyUsername.values().stream().toList();

        List<Dummy> anotherDummyList = new ArrayList<>();
        for (String userName : mapByDummyUsername.keySet()) {
            Dummy d = mapByDummyUsername.get(userName);
            anotherDummyList.add(d);
        }

        for (Dummy d : mapByDummyUsername.values()) {
            anotherDummyList.add(d);
        }

        for (Map.Entry<String,Dummy> entry : mapByDummyUsername.entrySet()) {
            String userName = entry.getKey();
            anotherDummyList.add(entry.getValue());
        }

        return dummiesList;

    }

    public String firstString() {
        return "I am ";
    }

    public abstract String callingFrom();


}
