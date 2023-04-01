package com.example.oregontrail;

import java.util.ArrayList;

/**
 *
 */
public class Person {

    private int cleanliness; // A percentage between 0 and 100.
    private ArrayList<Condition> conditions;
    private Emotion emotion;
    private int health; // A percentage between 0 and 100.
    private int hunger; // A percentage between 0 and 100.
    private int thirst; // A percentage between 0 and 100.
    private final String name;

    /**
     *
     * @param name
     */
    public Person(String name) {
        cleanliness = 100;
        emotion.setMood('N');
        health = 100;
        hunger = 100;
        this.name = name;
    }

    /**
     *
     * @return
     */
    public int getCleanliness() {
        return cleanliness;
    }

    public void clean(int amount) {
        cleanliness = cleanliness + amount;
    }

    /**
     *
     * @return
     */
    public ArrayList<Condition> getConditions() {
        return conditions;
    }

    /**
     *
     * @param condition
     */
    public void addCondition(Condition condition) {
        conditions.add(condition);
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
     *
     * @return
     */
    public Emotion getEmotion() {
        return emotion;
    }

    /**
     *
     * @param emotion
     */
    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }

    /**
     *
     * @return
     */
    public int getHealth() {
        return health;
    }

    /**
     *
     * @param damage
     */
    public void takeDamage(int damage) {
        health = health - damage;
    }

    /**
     *
     * @return
     */
    public int getHunger() {
        return hunger;
    }

    /**
     *
     * @param amount
     */
    public void eat(int amount) {
        hunger = hunger + amount;
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
    public int getThirst() {
        return thirst;
    }

    /**
     *
     * @param amount
     */
    public void drink(int amount) {
        thirst = thirst + amount;
    }
}
