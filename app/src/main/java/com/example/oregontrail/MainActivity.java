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
        final Button menu = findViewById(R.id.optionsButton);
        final Button start = findViewById(R.id.startButton);
        final TextView display = findViewById(R.id.oregonWelcome);
        final TextView menuDisplay = findViewById(R.id.menuDisplay);

        ArrayList<Place> Towns = new ArrayList<>();
        Towns.add(new Place("Independence", 1));
        Towns.add(new Place("Beaverton", 1));

        // FIXME: Several issues with the GUI, not entirely sure why.
        start.setOnClickListener(view -> {
            //Code to hide start button goes here
            final int[] day = {1};
            int temp = 100;

            end.setOnClickListener(view1 -> {
                day[0]++;
                display.setText("Day " + day[0]);
            });

            menu.setOnClickListener(view12 -> {
                //Displays condition
                menuDisplay.setText("Health: " + temp + "\nThirst: " + temp + "\nHunger: " + temp + "\nMood: " + temp);
            });
        });
    }
}