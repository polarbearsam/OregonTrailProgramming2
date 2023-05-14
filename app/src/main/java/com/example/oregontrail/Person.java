/**
 * File Name: Person.java
 * Date: March 27, 2023
 * @author Samuel Freer
 * Handles a person's stats.
 */
package com.example.oregontrail;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Creates a person for the game.
 */
public class Person extends Drawable {

    @Override
    public void draw(@NonNull Canvas canvas) {

    }

    @Override
    public void setAlpha(int i) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return 0;
    }

    public enum Emotion {
        ANGRY, HAPPY, ILL, NEUTRAL, SAD
    }

    /**
     * This function takes an emotion as an argument and returns the corresponding image.
     *
     * @param emotion (String): The emotion to switch the image for
     * @return (String): The name of the image file for the corresponding emotion
     */
    public static String switchImage(String emotion) {
        // Create a HashMap to store the emotion-image mappings
        HashMap<String, String> emotionImageMap = new HashMap<>();
        emotionImageMap.put("happy", "happy.jpg");
        emotionImageMap.put("sad", "sad.jpg");
        emotionImageMap.put("angry", "angry.jpg");
        emotionImageMap.put("ill", "ill.jpg");

        // Check if the emotion is in the map
        if (emotionImageMap.containsKey(emotion)) {
            // Return the corresponding image file name
            return emotionImageMap.get(emotion);
        } else {
            // Return default image file name
            return "neutral.jpg";
        }
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
        thirst = 100;
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
     *
     * @return The current emotion.
     */
    public Emotion getEmotion() {return emotion;}

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
    public boolean nextDay(Wagon wagon) {
        hunger = hunger - hungerRate;
        thirst = thirst - thirstRate;

        if (wagon.getItem("Water").getCount() >= 2 && thirst < 100) {
            drink(2);
            wagon.getItem("Water").removeFromCount(2);;
        }

        if (wagon.getItem("Food").getCount() >= 2 && hunger < 100) {
            eat(2);
            wagon.getItem("Food").removeFromCount(2);;
        }

        return hunger <= 0 || thirst <= 0 || health <= 0;
    }

    /**
     * Not Implemented
     * @param conditions to remove
     * @return true if the condition was found and removed, otherwise false.
     */
    public boolean removeCondition(ArrayList<Condition> conditions) {
        // TODO: Add functionality.
        this.conditions = conditions;
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