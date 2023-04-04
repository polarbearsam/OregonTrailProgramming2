package com.example.oregontrail;

/**
 *
 */
public class SuppliesEvent extends Event{
    /**
     *
     * @param frequency
     */
    public SuppliesEvent(double frequency) {
        super("Supplies", frequency);
        }

    /**
     *
     * @param wagon
     */
    @Override
    public void onEvent(Wagon wagon) {
        wagon.clothes += 5;
        wagon.food += 50;
        wagon.supplies += 100;
        wagon.water += 50;
    }
}
