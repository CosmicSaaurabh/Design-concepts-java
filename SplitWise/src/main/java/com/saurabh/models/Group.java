package com.saurabh.models;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Group {
    private  final String name;
    private final String description;

    private final List<User> users;
    public Group(String name, String description, List<User> users) {
        this.name = name;
        this.description = description;
        this.users = users;
    }

    public Collection<Object> getUsers() {
        return Collections.singleton(users);
    }
}
