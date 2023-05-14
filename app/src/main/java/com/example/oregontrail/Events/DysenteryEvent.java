/**
 * File Name: DysenteryEvent.java
 * Date: May 13, 2023
 * @author Samuel Freer
 * Description: Gives a person dysentery.
 */
package com.example.oregontrail.Events;

import com.example.oregontrail.Conditions.Dysentery;
import com.example.oregontrail.Event;
import com.example.oregontrail.MainActivity;
import com.example.oregontrail.Person;
import com.example.oregontrail.Wagon;

/**
 * Creates an event which gives a random person dysentery.
 */
public class DysenteryEvent extends Event {

    /**
     * Creates the DysenteryEvent event.
     * @param frequency the frequency at which the event will occur. Must be between 0 and 1.
     */
    public DysenteryEvent(double frequency) {
        super("Contracts Dysentery", frequency);
    }

    /**
     * Executes the event.
     * @param wagon the wagon that the event is happening to.
     * @return the text output for the event.
     */
    @Override
    public String onEvent(Wagon wagon) {
        Person person = wagon.getPeople().get(MainActivity.randomValue(wagon.getPeople().size(), 0));
        person.addCondition(new Dysentery(10));

        return person.getName() + " contracted Dysentery.";
    }
}
