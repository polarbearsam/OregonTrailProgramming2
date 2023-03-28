package com.example.oregontrail;

import java.util.ArrayList;

public class Condition {

    private final int duration;
    private final String name;

    /**
     *
     * @param duration
     * @param name
     */
    public Condition(int duration, String name) {
        this.duration = duration;
        this.name = name;
    }

    /**
     *
     * @return
     */
    public int getDuration() {
        return duration;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }
}
