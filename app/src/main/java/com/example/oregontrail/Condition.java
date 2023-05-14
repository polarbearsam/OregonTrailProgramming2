/**
 * File Name: Condition.java
 * Date: March 27, 2023
 * @author Samuel Freer
 * Description: Controls conditions that a person can have such as a disease.
 */
package com.example.oregontrail;

/**
 * Creates a condition that people can have.
 */
public abstract class Condition {

    private final int duration;
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
     * Executes the effects of the condition.
     * @param person person that the effects will apply to.
     * @return true if the condition should no longer apply, otherwise false.
     */
    public abstract boolean effects(Person person);

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
