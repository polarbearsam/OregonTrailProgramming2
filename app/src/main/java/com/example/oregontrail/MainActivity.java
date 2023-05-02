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
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Controls the main game and GUI elements.
 */
public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n") // Unclear why this is needed, but it is.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // GUI Elements
        final Button end = findViewById(R.id.endButton);
        final Button map = findViewById(R.id.mapButton);
        final Button menu = findViewById(R.id.optionsButton);
        final Button start = findViewById(R.id.startButton);
        final TextView display = findViewById(R.id.menuDisplay);
        final TextView location = findViewById(R.id.locationText);
        final TextView title = findViewById(R.id.oregonWelcome);

        ArrayList<Event> Events = new ArrayList<>();
        Events.add(new SuppliesEvent(0.1));

        ArrayList<Place> Towns = new ArrayList<>();
        Towns.add(new Place("Independence, Missouri"));
        Towns.add(new Place("Elk Grove, Nebraska"));
        Towns.add(new Place("Ash Hollow, Nebraska"));
        Towns.add(new Place("Chimney Rock, Nebraska"));
        Towns.add(new Place("Independence Rock, Wyoming"));



        Person hattie = new Person("Hattie Campbell");
        ArrayList<Person> people = new ArrayList<>();
        people.add(hattie);

        Wagon wagon = new Wagon(200, 8, 2000, 1, 1000,6, people, 3, 3, 3, 100);

        // Controls start button.
        start.setOnClickListener(view -> {
            // Code to hide start button goes here
            final int[] day = {0};
            start.setVisibility(View.GONE);

            // Controls the progression of time and travel simulation.
            end.setOnClickListener(view1 -> {
                // TODO: Implement random events.
                day[0]++;
                hattie.nextDay(wagon);
                location.setText("On the trail.");
                title.setText("Day " + day[0]);
            });

            // Displays a list of towns.
            map.setOnClickListener(view1 -> {
                // FIXME: Does not work.
                StringBuilder list = new StringBuilder();
                for (int i = 0; i < Towns.size(); i++) {
                    list.append(Towns.get(i));
                }

                display.setText(list);
            });

            // Controls the stats display.
            menu.setOnClickListener(view12 -> {
                // Displays stats
                display.setText("Hattie Campbell Stats = Health: " + hattie.getHealth() + "\nThirst: " + hattie.getThirst() + "\nHunger: " + hattie.getHunger() + "\nMood: " + hattie.getEmotion());
            });

        });
    }
}