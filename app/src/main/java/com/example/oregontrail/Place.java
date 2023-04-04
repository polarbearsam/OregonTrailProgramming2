package com.example.oregontrail;

import java.util.ArrayList;

/**
 * Uses and array to display the group location every time the advance button is pressed.
 */
public class Place {

    private final int location;
    private final String name;

    /**
     * Creates a new place to visit.
     * @param name Name of the place.
     * @param location Location on the trail.
     */
    public Place (String name, int location) {
        this.name = name;
        this.location = location;
    }
    /**
     * Obtains the name of the location.
     * @return location Location on the trail.
     */
    public int getLocation() {
        return location;
    }

    /**
     * Obtains the player names.
     * @return name Name of the place.
     */
    public String getName() {
        return name;
    }
}