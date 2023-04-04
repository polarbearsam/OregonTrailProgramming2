package com.example.oregontrail;

import java.util.ArrayList;

/**
 * Creates an event that can occur on the trail.
 */
public class Event {

    private ArrayList<Condition> conditions;
    private double frequency; // Represented as a percentage between 0 and 1.
    private final String name;

    /**
     * Creates an event which occurs with a set frequency during the game.
     * @param name Name of the event.
     * @param conditions A list of conditions caused by the event.
     * @param frequency A value between 0 and 1 representing how frequently this event can occur.
     */
    public Event(String name, ArrayList<Condition> conditions, double frequency) {
        this.conditions = conditions;
        this.frequency = frequency;
        this.name = name;
    }

    /**
     * Gets the name of the event.
     * @return The name of the event.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the frequency of the event.
     * @return The frequency of the event, which is a value between 0 and 1.
     */
    public double getFrequency() {
        return frequency;
    }

    /**
     * Sets the frequency of the event.
     * @param frequency The desired frequency of the event, which must be a value between 0 and 1.
     * @return True if the frequency was set correctly, otherwise returns false.
     */
    public boolean setFrequency(double frequency) {
        if (frequency >= 0 && frequency <= 1) {
            this.frequency = frequency;
            return true;
        }
        return false;
    }
}
