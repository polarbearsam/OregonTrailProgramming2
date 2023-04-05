package com.example.oregontrail;

/**
 * Creates a condition that people can have.
 * @author Samuel Freer
 */
public class Condition {

    // TODO: Implement Effects of Conditions.

    private final int duration;
    //private ArrayList<?> effects;
    private final String name;

    /**
     * Creates a new condition based on the following parameters.
     * @param duration The desired duration of the condition.
     * @param name The desired name of the condition.
     */
    public Condition(int duration, String name) {
        this.duration = duration;
        this.name = name;
    }

    /**
     * Gets the duration of the condition.
     * @return Duration of condition.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Gets the name of the condition.
     * @return Name of the condition.
     */
    public String getName() {
        return name;
    }

}
