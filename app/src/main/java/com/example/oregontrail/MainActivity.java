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
     * This function creates an ending for an Oregon Trail game based on the player's name, cause of death, and day.
     * Author: Samuel Freer and Destiny Morrison
     * @param name The player's name
     * @param day The day the player died
     * @return A string representing the player's ending
     */
    public static String createDeathEnding(String name, int day) {
        return "Here lies " + name + ". They died on day " + day + "." + "\n GAME OVER.";
    }


    // TODO Create function that sees if location is in Oregon, if so it'll display that you made it to Oregon.


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
        final Button end = findViewById(R.id.endButton);
        final Button map = findViewById(R.id.mapButton);
        final Button wagonButton = findViewById(R.id.wagonButton);
        final Button stats = findViewById(R.id.statsButton);
        final Button start = findViewById(R.id.startButton);
        final TextView display = findViewById(R.id.statsDisplay);
        final TextView location = findViewById(R.id.locationText);
        final TextView title = findViewById(R.id.oregonWelcome);
        ImageView mapView = findViewById(R.id.mapImage);
        ImageView model = findViewById(R.id.person);

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
        Towns.add(new Place("Elk Grove, Nebraska", 20));
        Towns.add(new Place("Ash Hollow, Nebraska", 40));
        Towns.add(new Place("Chimney Rock, Nebraska", 60));
        Towns.add(new Place("Independence Rock, Wyoming", 80));
        Towns.add(new Place("Oregon", 100));

        // Random Events
        ArrayList<Event> Events = new ArrayList<>();
        Events.add(new SuppliesEvent(1));
        Events.add(new TheftEvent(1));


        // Wagon
        Wagon wagon = new Wagon(items, 1000, 6, people);

        // Controls start button.
        start.setOnClickListener(view -> {

            mapView.setVisibility(View.INVISIBLE);

            // Code to hide start button goes here
            final int[] day = {0};
            start.setVisibility(View.INVISIBLE);

            // Controls the progression of time and travel simulation.
            end.setOnClickListener(view1 -> {
                boolean inCity = false;

                day[0]++;
                title.setText("Day " + day[0]);
                location.setText("On the trail.");
                hattie.nextDay(wagon);

                // Runs all the daily calculations for each character.
                for (int i = 0; i < wagon.getPeople().size(); i++) {
                    Person person = wagon.getPeople().get(i);


                    // Checks if person has died.
                    if (person.nextDay(wagon)) {
                        display.setText(createDeathEnding(person.getName(), day[0]));

                        if (person.getName().equals("Hattie Campbell")) {
                            // TODO: Reset game.
                            break;
                        }

                        wagon.getPeople().remove(person);
                    }
                }

                for (int i = 0; i < Towns.size(); i++) {
                    if(Towns.get(i).getLocation() == day[0]) {
                        location.setText(Towns.get(i).getName());
                        inCity = true;
                        break;
                    }
                }

                if (randomValue(10, 1) == 1 && !inCity) {
                    Events.get(randomValue(Events.size() - 1, 0)).onEvent(wagon);
                }

                // Emotion code
                // Runs through and checks emotion

                Person.Emotion emotion = hattie.getEmotion(); // Gets Emotion
                String emotionL = String.valueOf(emotion); // Changes emotion to string value


                if (emotion.equals(Person.Emotion.HAPPY)) {
                    model.setForeground(getDrawable(R.drawable.happy));
                } else if (emotion.equals(Person.Emotion.ANGRY)) {
                    model.setForeground(getDrawable(R.drawable.angry));
                } else if (emotion.equals(Person.Emotion.ILL)) {
                    model.setForeground(getDrawable(R.drawable.ill));
                } else if (emotion.equals(Person.Emotion.SAD)) {
                    model.setForeground(getDrawable(R.drawable.sad));
                } else if (emotion.equals(Person.Emotion.NEUTRAL)) {
                    model.setForeground(getDrawable(R.drawable.neutral));
                }

            });

            // Displays a list of towns.
            map.setOnClickListener(view1 -> {
                display.setVisibility(View.INVISIBLE);
                model.setVisibility(View.INVISIBLE);
                mapView.setVisibility(View.VISIBLE);
            });

            // Controls the stats display.
            stats.setOnClickListener(view12 -> {
                model.setVisibility(View.VISIBLE);
                mapView.setVisibility(View.INVISIBLE);
                // Displays stats
                display.setText("Hattie Campbell Stats = \n Health: " + hattie.getHealth() + "\nThirst: " + hattie.getThirst() + "\nHunger: " + hattie.getHunger() + "\nMood: " + hattie.getEmotion());
                display.setVisibility(View.VISIBLE);


            });

        });

        // Controls the wagon display.
        wagonButton.setOnClickListener(view12 -> {
            model.setVisibility(View.VISIBLE);
            mapView.setVisibility(View.INVISIBLE);
            // Displays wagon stats
            display.setText("Wagon Stats = \n Ammo: " + wagon.getItem("Ammo").getCount() + "\nClothes: " + wagon.getItem("Clothes").getCount() + "\nFood: " + wagon.getItem("Food").getCount() + "\nMedical Supplies: " + wagon.getItem("Medical Supplies").getCount() + "\nWater: " + wagon.getItem("Water").getCount());
            display.setVisibility(View.VISIBLE);

        });

    };


}
