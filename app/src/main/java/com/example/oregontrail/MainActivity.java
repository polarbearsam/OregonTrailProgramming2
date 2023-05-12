/**
 * File Name: MainActivity.java
 * Date: March 27, 2023
 * @author Chase Collert, Samuel Freer, and Destiny Morrison
 * Description: Controls the GUI and acts as the main game controller.
 */
package com.example.oregontrail;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oregontrail.Events.SuppliesEvent;
import com.example.oregontrail.Events.TheftEvent;

import java.util.ArrayList;
import java.util.Random;

/**
 * Controls the main game and GUI elements.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Generates a random number between the maxNumber and minNumber.
     * @param maxNumber Highest number to generate.
     * @param minNumber Lowest number to generate.
     * @return the randomly generated number.
     */
    public int randomValue(int maxNumber, int minNumber) {
        // create instance of Random class
        Random rand = new Random();

        // Generate random integers in range 0 to 9
        return rand.nextInt(maxNumber + 1 - minNumber) + minNumber;
    }

    @SuppressLint("SetTextI18n") // Unclear why this is needed, but it is.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // GUI Elements
        ImageView imageView = findViewById(R.id.imageView);
        final Button end = findViewById(R.id.endButton);
        final Button map = findViewById(R.id.mapButton);
        final Button menu = findViewById(R.id.statsButton);
        final Button start = findViewById(R.id.startButton);
        final TextView display = findViewById(R.id.statsDisplay);
        final TextView location = findViewById(R.id.locationText);
        final TextView title = findViewById(R.id.oregonWelcome);

        // Characters
        Person hattie = new Person("Hattie Campbell");
        ArrayList<Person> people = new ArrayList<>();
        people.add(hattie);

        // Items
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Ammo", 200, 0));
        items.add(new Item("Clothes", 8, 0));
        items.add(new Item("Food", 2000, 0));
        items.add(new Item("Medical Supplies", 1, 0));
        items.add(new Item("Spare Wagon Axles", 3, 0));
        items.add(new Item("Spare Wagon Tongues", 3, 0));
        items.add(new Item("Spare Wagon Wheels", 3, 0));
        items.add(new Item("Water", 100, 0));

        // List of locations on the trail.
        ArrayList<Place> Towns = new ArrayList<>();
        Towns.add(new Place("Independence, Missouri", 1));
        Towns.add(new Place("Elk Grove, Nebraska", 60));
        Towns.add(new Place("Ash Hollow, Nebraska", 100));
        Towns.add(new Place("Chimney Rock, Nebraska", 140));
        Towns.add(new Place("Independence Rock, Wyoming", 180));
        Towns.add(new Place("Oregon", 240));

        // Random Events
        ArrayList<Event> Events = new ArrayList<>();
        Events.add(new SuppliesEvent(1));
        Events.add(new TheftEvent(1));

        // Wagon
        Wagon wagon = new Wagon(items, 1000, 6, people);

        // Controls start button.
        start.setOnClickListener(view -> {
            // Code to hide start button goes here
            final int[] day = {0};
            start.setVisibility(View.INVISIBLE);

            // Controls the progression of time and travel simulation.
            end.setOnClickListener(view1 -> {
                boolean inCity = false;
                day[0]++;
                hattie.nextDay(wagon);
                location.setText("On the trail.");
                for (int i = 0; i < Towns.size(); i++) {
                    if(Towns.get(i).getLocation() == day[0]) {
                        location.setText(Towns.get(i).getName());
                        inCity = true;
                        break;
                    }
                }
                title.setText("Day " + day[0]);

                if (randomValue(10, 1) == 1 && !inCity) {
                    Events.get(randomValue(Events.size() - 1, 0)).onEvent(wagon);
                }
            });

            // Displays a list of towns.
            map.setOnClickListener(view1 -> {
                imageView.setVisibility(View.VISIBLE);
                display.setVisibility(View.INVISIBLE);
            });

            // Controls the stats display.
            menu.setOnClickListener(view12 -> {
                imageView.setVisibility(View.INVISIBLE);
                // Displays stats
                display.setText("Hattie Campbell Stats = Health: " + hattie.getHealth() + "\nThirst: " + hattie.getThirst() + "\nHunger: " + hattie.getHunger() + "\nMood: " + hattie.getEmotion());
                display.setVisibility(View.VISIBLE);
            });

        });
    }
}