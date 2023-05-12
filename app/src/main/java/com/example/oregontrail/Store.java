/**
 * File Name: Store.java
 * Date: May 12, 2023
 * @author Samuel Freer
 * Description: Creates a store where the player can buy items.
 */
package com.example.oregontrail;

import java.util.ArrayList;

/**
 * Creates a store.
 */
public class Store {

    private final ArrayList<Item> items;
    private final String name;
    private final String output;

    /**
     * Creates a basic store using the default text.
     * @param items Items in the store.
     */
    public Store(ArrayList<Item> items) {
        this.items = items;
        this.name = "Store";
        output = "I have several items for sale here.";
    }

    /**
     * Creates a store using the default text.
     * @param name Name of the store.
     * @param items Items in the store.
     */
    public Store(String name, ArrayList<Item> items) {
        this.items = items;
        this.name = name;
        output = "I have several items for sale here.";
    }

    /**
     * Creates a store.
     * @param name Name of the store.
     * @param items Items in the store.
     * @param output Text output for the store.
     */
    public Store(String name, ArrayList<Item> items, String output) {
        this.items = items;
        this.name = name;
        this.output = output;
    }

    /**
     * Gets a specific item from the wagon.
     * @param name Name of the item to get.
     * @param count Number of items to get.
     * @return The selected item(s). Returns null if not found or the request is too high.
     */
    public Item getItem(String name, int count) {
        for (int i = 0; i < items.size(); i++) {
            Item storeItem = items.get(i);

            if (storeItem.getName().equals(name)) {
                if (count <= storeItem.getCount()) {
                    Item playerItem = new Item(storeItem.getName(), count, storeItem.getValue());
                    storeItem.removeFromCount(count);

                    if (storeItem.getCount() == 0) {
                        items.remove(storeItem);
                    }

                    return playerItem;
                }

                return items.get(i);
            }
        }

        return null;
    }

    /**
     * Gets the list of items in the store.
     * @return list of items in the store.
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Gets the name of the store.
     * @return name of the store.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the text output for the store.
     * @return text output.
     */
    public String getOutput() {
        return output;
    }
}
