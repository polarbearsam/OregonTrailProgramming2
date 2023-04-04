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

        ArrayList<Place> Towns = new ArrayList<>();
        Towns.add(new Place("Independence, Missouri", 1));
        Towns.add(new Place("Beaverton", 50));

        Person hattie = new Person("Hattie Campbell");
        hattie.nextDay();

        // FIXME: Several issues with the GUI, not entirely sure why.
        start.setOnClickListener(view -> {
            //Code to hide start button goes here
            final int[] day = {0};
            int temp = 100;

            end.setOnClickListener(view1 -> {
                day[0]++;
                location.setText("On the trail.");
                for (int i = 0; i < Towns.size(); i++) {
                    if(Towns.get(i).getLocation() == day[0]) {
                        location.setText(Towns.get(i).getName());
                        break;
                    }
                }
                title.setText("Day " + day[0]);
            });

            map.setOnClickListener(view1 -> {
                StringBuilder list = new StringBuilder();
                for (int i = 0; i < Towns.size(); i++) {
                    list.append(Towns.get(i));
                }

                display.setText(list);
            });

            menu.setOnClickListener(view12 -> {
                //Displays condition
                display.setText("Health: " + temp + "\nThirst: " + temp + "\nHunger: " + temp + "\nMood: " + temp);
            });
        });
    }
}