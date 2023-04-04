package com.example.oregontrail;

/**
 * Holds randomized supply event that gives the player more supplies
 */
public class SuppliesEvent extends Event{
    /**
     *  Gives the frequency to which supplies will be found by player
     * @param frequency
     */
    public SuppliesEvent(double frequency) {
        super("Supplies", frequency);
        }

    /**
     *  Adds supplies to wagon
     * @param wagon
     */
    @Override
    public void onEvent(Wagon wagon) {
        wagon.clothes += 5;
        wagon.food += 50;
    }
}
