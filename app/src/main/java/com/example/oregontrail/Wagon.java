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

    public int ammo;
    public int clothes;
    public int food;
    public int heirlooms;
    public int medicalSupplies;
    public int money;
    public int oxen;
    private ArrayList<Person> people;
    public int spareWagonAxles;
    public int spareWagonTongues;
    public int spareWagonWheels;
    public int water;

    /**
     * Creates a wagon which stores the following resources:
     * @param clothes number of clothes
     * @param food amount of food
     * @param medicalSupplies medical supplies
     * @param oxen number of oxen
     * @param people list of pioneers
     * @param spareWagonAxles spare axles
     * @param spareWagonTongues spare tongues
     * @param spareWagonWheels spare wheels
     * @param water amount of water
     */
    public Wagon(int ammo, int clothes, int food, int medicalSupplies, int money, int oxen, ArrayList<Person> people, int spareWagonAxles, int spareWagonTongues, int spareWagonWheels, int water) {
        this.ammo = ammo;
        this.clothes = clothes;
        this.food = food;
        this.heirlooms = 5;
        this.medicalSupplies = medicalSupplies;
        this.money = money;
        this.oxen = oxen;
        this.people = people;
        this.spareWagonAxles = spareWagonAxles;
        this.spareWagonTongues = spareWagonTongues;
        this.spareWagonWheels = spareWagonWheels;
        this.water = water;
    }

    /**
     * Gets the list of pioneers in the wagon.
     * @return list of pioneers
     */
    public ArrayList<Person> getPeople() {
        return people;
    }

    /**
     * Adds a new pioneer to the wagon.
     * @param person person to be added to the wagon.
     */
    public void addPerson(Person person) {
        people.add(person);
    }
}
