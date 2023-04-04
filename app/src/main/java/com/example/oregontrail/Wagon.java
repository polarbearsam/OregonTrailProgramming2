package com.example.oregontrail;


import java.util.ArrayList;

/**
 *
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
     *
     * @return
     */
    public ArrayList<Person> getPeople() {
        return people;
    }
}
