package com.company.inheritance.example;

import java.util.HashMap;
import java.util.Map;

public class ParentCollection {

    private final Map<Integer,Parent> parentsMapById;
    private final Map<String,Parent> parentsMapByUserName;

    public ParentCollection() {
        parentsMapByUserName = new HashMap<>();
        parentsMapById = new HashMap<>();
    }

    public Map<Integer, Parent> getParentsMapById() {
        return parentsMapById;
    }

    public void addParentToMap(String userName, String name) {

        boolean userNameAlreadyExists = parentsMapByUserName.containsKey(userName);
        if (userNameAlreadyExists) {
            throw new IllegalArgumentException("Username is already in use in parent's map");
        }

        Parent parent = new Parent(userName,name);

        this.parentsMapById.put(parent.getId(), parent);
        this.parentsMapByUserName.put(parent.getUserName(), parent);
    }

    public void addDummyToParent(CollectionEnum collectionEnum,
                                 int parentId,
                                 String dummyUsername,
                                 String dummyAttribute,
                                 String anotherAttribute) {


        boolean parentIsNotPresent = !parentsMapById.containsKey(parentId);

        if (parentIsNotPresent || parentsMapById.isEmpty() ) {
            throw new IllegalArgumentException("Map is void or parent doesn't exist");
        }
        Dummy dummy = new Dummy(dummyUsername,dummyAttribute,anotherAttribute);
        Parent parent = parentsMapById.get(parentId);

        if (collectionEnum.equals(CollectionEnum.SET)) {
            parent.addObjectToMySet(dummyUsername,dummyAttribute,anotherAttribute);
        }

        if (collectionEnum.equals(CollectionEnum.LIST)) {
            parent.addObjectToMyList(dummyUsername,dummyAttribute,anotherAttribute);
        }

        if (collectionEnum.equals(CollectionEnum.MAP)) {
            parent.addObjectToMyMaps(dummyUsername,dummyAttribute,anotherAttribute);
        }

    }
}
