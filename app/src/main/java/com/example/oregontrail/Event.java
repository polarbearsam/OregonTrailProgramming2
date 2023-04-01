package com.example.oregontrail;

import java.util.ArrayList;

/**
 * Creates an event that can occur on the trail.
 */
public class Event {

    private ArrayList<Condition> conditions;
    private double frequency; // Represented as a percentage between 0 and 1.
    private String name;

    /**
     *
     * @param name
     * @param conditions
     * @param frequency A value between 0 and 1 representing how frequently this event can occur.
     */
    public Event(String name, ArrayList<Condition> conditions, double frequency) {
        this.conditions = conditions;
        this.frequency = frequency;
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public double getFrequency() {
        return frequency;
    }

    /**
     *
     * @param frequency
     */
    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }
}
