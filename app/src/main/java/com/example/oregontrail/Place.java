/**
 * File Name: Place.java
 * Date: March 27, 2023
 * @author Chase Collert, Samuel Freer, and Destiny Morrison
 * Description: Controls the handling of special places like towns.
 */
package com.example.oregontrail;

/**
 * Uses and array to display the group location every time the advance button is pressed.
 */
public class Place {

    private final String name;

    /**
     * Creates a new place to visit.
     * @param name Name of the place.
     */
    public Place (String name) {
        this.name = name;
    }

    /**
     * Obtains the player names.
     * @return name Name of the place.
     */
    public String getName() {
        return name;
    }
}