/**
 * File Name: SuppliesEvent.java
 * Date: April 4, 2023
 * @author Samuel Freer
 * Description: Adds more supplies.
 */
package com.example.oregontrail.Events;

import com.example.oregontrail.Event;
import com.example.oregontrail.Person;
import com.example.oregontrail.Wagon;

/**
 * Holds randomized supply event that gives the player more supplies
 */
public class SuppliesEvent extends Event {

    /**
     * Gives the frequency to which supplies will be found by player
     * @param frequency the frequency at which the event will occur. Must be between 0 and 1.
     */
    public SuppliesEvent(double frequency) {
        super("Theft", frequency);
        }

    /**
     * Adds supplies to wagon
     * @param wagon the wagon that the event is happening to.
     * @return the text output for the event.
     */
    @Override
    public String onEvent(Wagon wagon) {
        wagon.getItem("Ammo").addToCount(25);
        wagon.getItem("Clothes").addToCount(3);
        wagon.getItem("Food").addToCount(50);

        for (int i = 0; i < wagon.getPeople().size(); i++) {
            wagon.getPeople().get(i).setEmotion(Person.Emotion.HAPPY);
        }

        return "You find some extra supplies on the side of the trail.";
    }
}
