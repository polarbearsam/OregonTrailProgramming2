package com.example.oregontrail;

import java.util.ArrayList;

public class Event {

    private ArrayList<Condition> conditions;
    private String name;

    public Event(String name, ArrayList<Condition> conditions) {
        this.name = name;
        this.conditions = conditions;
    }

    public String getName() {
        return name;
    }
}
