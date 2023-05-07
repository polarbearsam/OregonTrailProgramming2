package com.example.oregontrail;

public class Item {

    private int count;
    private final String name;
    private final int value;

    public Item(String name, int count, int value) {
        this.name = name;
        this.count = count;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getValue() {
        return value;
    }
}
