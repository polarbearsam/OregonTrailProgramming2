/**
 * File Name: Place.java
 * Date: March 27, 2023
 * @author Chase Collert, Samuel Freer, and Destiny Morrison
 * Description: Controls the handling of special places like towns.
 */
package com.example.oregontrail;

import java.util.ArrayList;

/**
 * Uses and array to display the group location every time the advance button is pressed.
 */
public class Place {

    private final int location;
    private final String name;
    private final ArrayList<Store> stores;

    /**
     * Creates a new place to visit.
     * @param name Name of the place.
     * @param location Location on the trail.
     */
    public Place (String name, int location) {
        this.name = name;
        this.location = location;
        stores = new ArrayList<>();
    }

    /**
     * Creates a new place to visit with stores.
     * @param name Name of the place.
     * @param location Location on the trail.
     * @param stores List of stores.
     */
    public Place (String name, int location, ArrayList<Store> stores) {
        this.name = name;
        this.location = location;
        this.stores = stores;

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

    /**
     * Gets the list of stores in the location.
     * @return list of stores in the location.
     */
    public ArrayList<Store> getStores() {
        return stores;
    }
}