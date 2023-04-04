package com.example.oregontrail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Controls the main game and GUI elements.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Start button code
        final Button start = findViewById(R.id.startButton);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int day = 0;
                final TextView display = (TextView) findViewById(R.id.OreganWelcome);
                final TextView end = (TextView) findViewById(R.id.endButton);
                final TextView menu = (TextView) findViewById(R.id.optionsButton);
                final TextView menuDisplay = (TextView) findViewById(R.id.menuDisplay);
                //Code to hide start button goes here
                boolean endDay = false;
                int temp = 100;
                day = 1;

                if (end.isEnabled()) { //If the end day button is clicked
                    endDay = true;
                }
                if (endDay = true) {
                    day = day + 1;
                }

                if (day == 1) {
                    display.setText("Day 1");
                } else if (day == 2) {
                    display.setText("Day 2");
                } else if (day == 3) {
                    display.setText("Day 3");
                } else if (day == 4) {
                    display.setText("Day 4");
                } else if (day == 5) {
                    display.setText("Day 5");
                } // And so on for however many days!

                if (menu.isEnabled()){ //When the menu button is clicked
                    //Displays condition
                    menuDisplay.setText("Health: " + temp + "\nThirst: " + temp + "\nHunger: " + temp + "\nMood: " + temp);

                }

            }
        });

    }
}