/**
 * File Name: Wagon.java
 * Date: April 4, 2023
 * @author Samuel Freer
 * Description: Stores the party's resources.
 */
package com.example.oregontrail;

import java.util.ArrayList;

/**
 * Handles resources which are stored in the wagon.
 */
public class Wagon {

    private ArrayList<Item> items;
    private int money;
    private int oxen;
    private ArrayList<Person> people;

    /**
     * Creates a wagon which stores the following resources:
     * @param items list of items in the wagon
     * @param oxen number of oxen
     * @param people list of pioneers
     */
    public Wagon(ArrayList<Item> items, int money, int oxen, ArrayList<Person> people) {
        this.items = items;
        this.money = money;
        this.oxen = oxen;
        this.people = people;
    }

    /**
     * Adds a new pioneer to the wagon.
     * @param person person to be added to the wagon.
     */
    public void addPerson(Person person) {
        people.add(person);
    }

    /**
     * Gets the list of items in the wagon.
     * @return list of items in the wagon.
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Gets a specific item from the wagon.
     * @param name Name of the item to get.
     * @return The selected item. Returns null if not found.
     */
    public Item getItem(String name) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(name)) {
                return items.get(i);
            }
        }

        return null;
    }

    /**
     * Gets the amount of money.
     * @return Amount of money.
     */
    public int getMoney() {
        return money;
    }

    /**
     * Gets the number of oxen.
     * @return Number of oxen.
     */
    public int getOxen() {
        return oxen;
    }

    /**
     * Gets the list of pioneers in the wagon.
     * @return list of pioneers
     */
    public ArrayList<Person> getPeople() {
        return people;
    }

    /**
     * Sets the list of items in the wagon.
     * @param items list of items in the wagon.
     */
    @Deprecated
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    /**
     * Sets the amount of money.
     * @param money Amount of money.
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * Sets the number of oxen.
     * @param oxen Number of oxen.
     */
    public void setOxen(int oxen) {
        this.oxen = oxen;
    }
}
