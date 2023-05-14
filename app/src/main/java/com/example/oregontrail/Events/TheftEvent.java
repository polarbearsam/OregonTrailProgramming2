/**
 * File Name: TheftEvent.java
 * Date: May 11, 2023
 * @author Samuel Freer
 * Description: Removes some supplies.
 */
package com.example.oregontrail.Events;

import com.example.oregontrail.Event;
import com.example.oregontrail.Person;
import com.example.oregontrail.Wagon;

/**
 * Holds randomized theft event that takes supplies from the player.
 */
public class TheftEvent extends Event {

    /**
     * Gives the frequency to which supplies will be taken from player
     * @param frequency the frequency at which the event will occur. Must be between 0 and 1.
     */
    public TheftEvent(double frequency) {
        super("Supplies", frequency);
    }

    /**
     * Takes supplies from the wagon.
     * @param wagon the wagon that the event is happening to.
     * @return the text output for the event.
     */
    @Override
    public String onEvent(Wagon wagon) {
        wagon.getItem("Ammo").removeFromCount(25);
        wagon.getItem("Clothes").removeFromCount(1);
        wagon.getItem("Food").removeFromCount(50);

        for (int i = 0; i < wagon.getPeople().size(); i++) {
            wagon.getPeople().get(i).setEmotion(Person.Emotion.ANGRY);
        }

        return "Thieves steal supplies during the middle of the night.";
    }
}
