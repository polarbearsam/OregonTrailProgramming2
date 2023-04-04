package com.example.oregontrail;


import java.util.ArrayList;

/**
 *
 */
public class Wagon {

    public int clothes;
    public int food;
    public int oxen;
    private ArrayList<Person> people;
    public int supplies;
    public int water;

    /**
     *
     * @param clothes
     * @param food
     * @param oxen
     * @param people
     * @param supplies
     * @param water
     */
    public Wagon(int clothes, int food, int oxen, ArrayList<Person> people, int supplies, int water) {
        this.clothes = clothes;
        this.food = food;
        this.oxen = oxen;
        this.people = people;
        this.supplies = supplies;
        this.water = water;
    }

    /**
     *
     * @return
     */
    public ArrayList<Person> getPeople() {
        return people;
    }
}
