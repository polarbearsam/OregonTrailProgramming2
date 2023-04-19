/**
 * File Name: Person.java
 * Date: March 27, 2023
 * @author Samuel Freer
 * Handles a person's stats.
 */
package com.example.oregontrail;

import java.util.ArrayList;

/**
 * Creates a person for the game.
 */
public class Person {

    public enum Emotion {
        ANGRY, HAPPY, ILL, NEUTRAL, SAD
    }

    private int cleanliness; // A percentage between 0 and 100.
    private ArrayList<Condition> conditions;
    private Emotion emotion;
    private int health; // A percentage between 0 and 100.
    private int hunger; // A percentage between 0 and 100.
    private int hungerRate = 1;
    private int thirst; // A percentage between 0 and 100.
    private int thirstRate = 1;
    private final String name;

    /**
     * Creates a person.
     * @param name Name of the person.
     */
    public Person(String name) {
        cleanliness = 100;
        emotion = Emotion.NEUTRAL;
        health = 100;
        hunger = 100;
        this.name = name;
    }

    /**
     * Adds a condition to the person.
     * @param condition Condition to add.
     */
    public void addCondition(Condition condition) {
        conditions.add(condition);
    }

    /**
     * Improves the person's cleanliness.
     * @param amount The amount of cleanliness to restore.
     */
    public void clean(int amount) {
        cleanliness = cleanliness + amount;
        if (cleanliness > 100) {
            cleanliness = 100;
        }
    }

    /**
     * Reduces the person's thirst.
     * @param amount Amount of thirst to remove.
     */
    public void drink(int amount) {
        thirst = thirst + amount;
        if (thirst > 150) {
            thirst = 150;
        }
    }

    /**
     * Reduce's the person's hunger.
     * @param amount Amount of hunger to remove.
     */
    public void eat(int amount) {
        hunger = hunger + amount;
        if (hunger > 150) {
            hunger = 150;
        }
    }

    /**
     * Gets the person's cleanliness.
     * @return Cleanliness between 0 and 100.
     */
    public int getCleanliness() {
        return cleanliness;
    }

    /**
     * Gets the person's conditions.
     * @return A list of conditions afflicting the person.
     */
    public ArrayList<Condition> getConditions() {
        return conditions;
    }


    /**
     * Gets the person's current emotion.
     * @return The current emotion.
     */
    public Emotion getEmotion() {
        return emotion;
    }

    /**
     * Gets the person's health.
     * @return Health between 0 and 100.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Gets the person's hunger.
     * @return Hunger between 0 and 150.
     */
    public int getHunger() {
        return hunger;
    }

    /**
     * Gets the person's current hunger rate.
     * @return Current hunger rate.
     */
    public int getHungerRate() {
        return hungerRate;
    }

    /**
     * Gets the person's name.
     * @return Person's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the person's thirst.
     * @return Thirst between 0 and 150.
     */
    public int getThirst() {
        return thirst;
    }

    /**
     * Gets the current thirst rate.
     * @return The current thirst rate.
     */
    public int getThirstRate() {
        return thirstRate;
    }

    /**
     * Controls automatic actions which occur every day.
     * @return Returns true if the player is dead, otherwise returns false.
     */
    public boolean nextDay() {
        hunger = hunger - hungerRate;
        thirst = thirst - thirstRate;

        return hunger == 0 || thirst == 0 || health == 0;
    }

    /**
     * Not Implemented
     * @param condition to remove
     * @return true if the condition was found and removed, otherwise false.
     */
    public boolean removeCondition(Condition condition) {
        // TODO: Add functionality.
        return false;
    }

    /**
     * Sets the person's current emotion.
     * @param emotion Desired emotion.
     */
    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }

    /**
     * Controls how fast a person gets hungry.
     * @param hungerRate The desired hunger rate.
     */
    public void setHungerRate(int hungerRate) {
        this.hungerRate = hungerRate;
    }

    /**
     * Controls how fast a person gets thirsty.
     * @param thirstRate The desired thirst rate.
     */
    public void setThirstRate(int thirstRate) {
        this.thirstRate = thirstRate;
    }

    /**
     * Deals damage to the person.
     * @param damage The amount of damage desired.
     */
    public void takeDamage(int damage) {
        health = health - damage;
        if (health <= 0) {
            health = 0;
        }
    }
}