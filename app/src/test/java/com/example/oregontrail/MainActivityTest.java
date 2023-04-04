package com.example.oregontrail;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import junit.framework.TestCase;

public class MainActivityTest extends TestCase {
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
            // TODO: Add all GUI Elements here.
            //Start button code

            start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int day = 0;
                    final TextView display = (TextView) findViewById(R.id.OreganWelcome);
                    final Button end = (Button) findViewById(R.id.endButton);
                    final Button menu = (Button) findViewById(R.id.optionsButton);
                    final Button map = (Button) findViewById(R.id.button4);
                    final TextView menuDisplay = (TextView) findViewById(R.id.menuDisplay);
                    final TextView location = (TextView) findViewById(R.id.locationText);
                    int currentClean = 100 ; // A percentage between 0 and 100.
                    int currentHealth = 100 ; // A percentage between 0 and 100.
                    int currentHunger = 0 ; // A percentage between 0 and 100.
                    int currentThirst = 0 ; // A percentage between 0 and 100.
                    String player = "Hattie Campbell";

                    //Code to hide start button goes here
                    boolean endDay = false;
                    int temp = 100;
                    day = 1;

                   /*
                     if (map.isPressed()){
                        menuDisplay.setBackground(); // Set the background of that image to an oregon trail map
                     }
                    */
                    if (end.isPressed()) { //If the end day button is clicked
                        endDay = true;
                        currentHunger += 10;
                        currentThirst += 10;
                    }
                    if (endDay = true) {
                        day += 1;
                    }

                    if (day == 1) {
                        display.setText("Day 1");
                        location.setText("Location: Independance Missouri");
                    } else if (day == 2) {
                        display.setText("Day 2");
                        location.setText("Location: templocation2");
                    } else if (day == 3) {
                        display.setText("Day 3");
                        location.setText("Location: templocation3");
                    } else if (day == 4) {
                        display.setText("Day 4");
                        location.setText("Location: templocation4");
                    } else if (day == 5) {
                        display.setText("Day 5");
                        location.setText("Location: templocation5"); // Final location should be Ash Hallow Nebraska
                    } // And so on for however many days!

                    if (menu.isPressed()){ //When the menu button is clicked
                        //Displays conditions of character
                        menuDisplay.setText("Hattie Campbell-- Stats" + "\nHealth: " + currentHealth + "\nThirst: " + currentThirst + "\nHunger: " + currentHunger + "\nMood: " + temp);

                    }


                }
            });

            // TODO: Implement functionality.
        }
    }
}