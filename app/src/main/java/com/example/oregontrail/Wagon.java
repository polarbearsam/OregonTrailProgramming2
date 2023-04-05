package com.example.oregontrail;


import java.util.ArrayList;

/**
 * Handles resources which are stored in the wagon.
 * @author Samuel Freer
 */
public class Wagon {

    public int ammo;
    public int clothes;
    public int food;
    public int heirlooms;
    public int medicalSupplies;
    public int oxen;
    private ArrayList<Person> people;
    public int spareWagonAxles;
    public int spareWagonTongues;
    public int spareWagonWheels;

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
     */
    public Wagon(int clothes, int food, int medicalSupplies, int oxen, ArrayList<Person> people, int spareWagonAxles, int spareWagonTongues, int spareWagonWheels) {
        this.clothes = clothes;
        this.food = food;
        this.heirlooms = 5;
        this.medicalSupplies = medicalSupplies;
        this.oxen = oxen;
        this.people = people;
        this.spareWagonAxles = spareWagonAxles;
        this.spareWagonTongues = spareWagonTongues;
        this.spareWagonWheels = spareWagonWheels;
    }

    /**
     * Gets the list of pioneers in the wagon.
     * @return list of pioneers
     */
    public ArrayList<Person> getPeople() {
        return people;
    }
}
