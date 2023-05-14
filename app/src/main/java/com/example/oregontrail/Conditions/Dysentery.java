/**
 * File Name: Dysentery.java
 * Date: May 13, 2023
 * @author Samuel Freer
 * Description: Defines the effects of having dysentery.
 */
package com.example.oregontrail.Conditions;

import com.example.oregontrail.Condition;
import com.example.oregontrail.Person;

/**
 * Defines the effects of having dysentery.
 */
public class Dysentery extends Condition {

    private int days = 0;

    /**
     * Creates the dysentery condition.
     * @param duration length of the dysentery.
     */
    public Dysentery(int duration) {
        super(duration, "Dysentery");
    }

    /**
     * Executes the effects of the condition.
     * @param person person that the effects will apply to.
     * @return true if the condition should no longer apply, otherwise false.
     */
    @Override
    public boolean effects(Person person) {
        days++;

        person.setEmotion(Person.Emotion.ILL);
        person.eat(3);
        person.drink(3);

        return days >= getDuration();
    }
}
