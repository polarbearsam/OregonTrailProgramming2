package com.example.oregontrail;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

        // GUI Elements
        final Button start = findViewById(R.id.startButton);
        final TextView display = (TextView) findViewById(R.id.OreganWelcome);
        final TextView end = (TextView) findViewById(R.id.endButton);
        final TextView menu = (TextView) findViewById(R.id.optionsButton);
        final TextView menuDisplay = (TextView) findViewById(R.id.menuDisplay);

        // FIXME: Several issues with the GUI, not entirely sure why.
        start.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n") // Unclear why this is needed, but it is.
            @Override
            public void onClick(View view) {
                //Code to hide start button goes here
                int day = 1;
                int temp = 100;

                // FIXME: This loop throws exceptions?
                while (true) {
                    boolean endDay = false;

                    if (end.isEnabled()) { //If the end day button is clicked
                        day++;
                        display.setText("Day " + day);
                    }

                    if (menu.isEnabled()) { //When the menu button is clicked
                        //Displays condition
                        menuDisplay.setText("Health: " + temp + "\nThirst: " + temp + "\nHunger: " + temp + "\nMood: " + temp);

                    }
                }
            }
        });
    }
}