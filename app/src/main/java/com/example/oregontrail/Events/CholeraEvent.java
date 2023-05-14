/**
 * File Name: CholeraEvent.java
 * Date: May 13, 2023
 * @author Samuel Freer
 * Description: Gives a person cholera.
 */
package com.example.oregontrail.Events;

import com.example.oregontrail.Conditions.Cholera;
import com.example.oregontrail.Event;
import com.example.oregontrail.MainActivity;
import com.example.oregontrail.Person;
import com.example.oregontrail.Wagon;

/**
 * Creates an event which gives a random person cholera.
 */
public class CholeraEvent extends Event {

    /**
     * Creates the ContractsCholera event.
     * @param frequency the frequency at which the event will occur. Must be between 0 and 1.
     */
    public CholeraEvent(double frequency) {
        super("Contracts Cholera", frequency);
    }

    /**
     * Gives a random person cholera.
     * @param wagon the wagon that the event is happening to.
     * @return the text output for the event.
     */
    @Override
    public String onEvent(Wagon wagon) {
        Person person = wagon.getPeople().get(MainActivity.randomValue(wagon.getPeople().size() - 1, 0));
        person.addCondition(new Cholera(10));
        return person.getName() + " contracted Cholera.";
    }
}
