/**
 * File Name: Item.java
 * Date: May 7, 2023
 * @author Samuel Freer
 * Description: Handles details about items such as their value and name.
 */
package com.example.oregontrail;

/**
 * Creates an item type for items.
 */
public class Item {

    private int count;
    private final String name;
    private final int value;

    /**
     * Creates a new item.
     * @param name Name of the item.
     * @param count Number of items.
     * @param value Value of the item.
     */
    public Item(String name, int count, int value) {
        this.name = name;
        this.count = count;
        this.value = value;
    }

    /**
     * Gets the name of the item.
     * @return Returns the name of item.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the number of items.
     * @return Returns the number of items.
     */
    public int getCount() {
        return count;
    }

    /**
     * Adds more items.
     * @param count Number of items to add.
     */
    public void addToCount(int count) {
        this.count += count;
    }

    /**
     * Removes items.
     * @param count Nymber of items to remove.
     */
    public void removeFromCount(int count) {
        this.count -= count;
    }

    /**
     * Gets the value of the item.
     * @return The value of the item.
     */
    public int getValue() {
        return value;
    }
}
