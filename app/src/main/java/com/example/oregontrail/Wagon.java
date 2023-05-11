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

    private int ammo;
    private int clothes;
    private int food;
    private int heirlooms;
    private int medicalSupplies;
    private int money;
    private int oxen;
    private ArrayList<Person> people;
    private int spareWagonAxles;
    private int spareWagonTongues;
    private int spareWagonWheels;
    private int water;

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

    /**
     * Gets the amount of ammo.
     * @return Amount of ammo.
     */
    public int getAmmo() {
        return ammo;
    }

    /**
     * Sets the amount of ammo.
     * @param ammo Amount of ammo.
     */
    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    /**
     * Gets the amount of clothes.
     * @return Amount of clothes.
     */
    public int getClothes() {
        return clothes;
    }

    /**
     * Sets the amount of clothes.
     * @param clothes Amount of clothes.
     */
    public void setClothes(int clothes) {
        this.clothes = clothes;
    }

    /**
     * Gets the amount of food.
     * @return Amount of food.
     */
    public int getFood() {
        return food;
    }

    /**
     * Sets the amount of food.
     * @param food Amount of food.
     */
    public void setFood(int food) {
        this.food = food;
    }

    /**
     * Gets the number of heirlooms.
     * @return Number of heirlooms.
     */
    public int getHeirlooms() {
        return heirlooms;
    }

    /**
     * Sets the number of heirlooms.
     * @param heirlooms Number of heirlooms.
     */
    public void setHeirlooms(int heirlooms) {
        this.heirlooms = heirlooms;
    }

    /**
     * Gets the amount of medical supplies.
     * @return Amount of medical supplies.
     */
    public int getMedicalSupplies() {
        return medicalSupplies;
    }

    /**
     * Sets the amount of medical supplies.
     * @param medicalSupplies Amount of medical supplies.
     */
    public void setMedicalSupplies(int medicalSupplies) {
        this.medicalSupplies = medicalSupplies;
    }

    /**
     * Gets the amount of money.
     * @return Amount of money.
     */
    public int getMoney() {
        return money;
    }

    /**
     * Sets the amount of money.
     * @param money Amount of money.
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * Gets the number of oxen.
     * @return Number of oxen.
     */
    public int getOxen() {
        return oxen;
    }

    /**
     * Sets the number of oxen.
     * @param oxen Number of oxen.
     */
    public void setOxen(int oxen) {
        this.oxen = oxen;
    }

    /**
     * Gets the number of spare wagon axles.
     * @return Number of spare wagon axles.
     */
    public int getSpareWagonAxles() {
        return spareWagonAxles;
    }

    /**
     * Sets the number of spare wagon axles.
     * @param spareWagonAxles Number of spare wagon axles.
     */
    public void setSpareWagonAxles(int spareWagonAxles) {
        this.spareWagonAxles = spareWagonAxles;
    }

    /**
     * Gets the number of spare wagon tongues.
     * @return Number of spare wagon tongues.
     */
    public int getSpareWagonTongues() {
        return spareWagonTongues;
    }

    /**
     * Sets the number of spare wagon tongues.
     * @param spareWagonTongues Number of spare wagon tongues.
     */
    public void setSpareWagonTongues(int spareWagonTongues) {
        this.spareWagonTongues = spareWagonTongues;
    }

    /**
     * Gets the number of spare wagon wheels.
     * @return Number of spare wagon wheels.
     */
    public int getSpareWagonWheels() {
        return spareWagonWheels;
    }

    /**
     * Sets the number of spare wagon wheels.
     * @param spareWagonWheels Number of spare wagon wheels.
     */
    public void setSpareWagonWheels(int spareWagonWheels) {
        this.spareWagonWheels = spareWagonWheels;
    }

    /**
     * Gets the amount of water.
     * @return Amount of water.
     */
    public int getWater() {
        return water;
    }

    /**
     * Sets the amount of water.
     * @param water Amount of water.
     */
    public void setWater(int water) {
        this.water = water;
    }
}
