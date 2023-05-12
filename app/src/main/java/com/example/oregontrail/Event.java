/**
 * File Name: Event.java
 * Date: March 27, 2023
 * @author Samuel Freer
 * Description: Establishes an abstract class that events can extend.
 */
package com.example.oregontrail;

/**
 * Creates an event that can occur on the trail.
 */
public abstract class Event {

    private final double frequency; // Represented as a percentage between 0 and 1.
    private final String name;

    /**
     * Creates an event which occurs with a set frequency during the game.
     * @param name Name of the event.
     * @param frequency A value between 0 and 1 representing how frequently this event can occur.
     */
    public Event(String name, double frequency) {
        this.frequency = frequency;
        this.name = name;
    }

    /**
     * Gets the frequency of the event.
     * @return The frequency of the event, which is a value between 0 and 1.
     */
    public double getFrequency() {
        return frequency;
    }

    /**
     * Gets the name of the event.
     * @return The name of the event.
     */
    public String getName() {
        return name;
    }

    /**
     * Executes the event.
     * @param wagon the wagon that the event is happening to.
     * @return the text output for the event.
     */
    public abstract String onEvent(Wagon wagon);
}
