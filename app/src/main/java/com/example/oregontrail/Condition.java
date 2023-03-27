package com.example.oregontrail;

import java.util.ArrayList;

public class Condition {

    private ArrayList<Person> afflicted;
    private int duration;
    private String name;

    public Condition(int duration, String name) {
        this.duration = duration;
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Person> getAfflicted() {
        return afflicted;
    }

    public void setAfflicted(ArrayList<Person> afflicted) {
        this.afflicted = afflicted;
    }
}
