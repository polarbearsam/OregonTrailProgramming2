/**
 * File Name: Cholera.java
 * Date: May 13, 2023
 * @author Samuel Freer
 * Description: Defines the effects of having cholera.
 */
package com.example.oregontrail.Conditions;

import com.example.oregontrail.Condition;
import com.example.oregontrail.Person;

/**
 * Defines the effects of having cholera.
 */
public class Cholera extends Condition {

    private int days = 0;

    /**
     * Creates the cholera condition.
     * @param duration length of the cholera.
     */
    public Cholera(int duration) {
        super(duration, "Cholera");
    }

    /**
     * Controls the effects of the cholera condition.
     * @param person person that the effects will apply to.
     * @return true if the condition should no longer apply, otherwise false.
     */
    @Override
    public boolean effects(Person person) {
        days++;

        person.setEmotion(Person.Emotion.ILL);
        person.setThirstRate(5);

        return days >= getDuration();
    }
}
