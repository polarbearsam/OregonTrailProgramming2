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

import com.example.oregontrail.Events.CholeraEvent;
import com.example.oregontrail.Events.DysenteryEvent;
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
        return "Here lies " + name + ". They died on day " + day + ".";
    }

    /**
     * Generates a random number between the maxNumber and minNumber.
     * @param maxNumber Highest number to generate.
     * @param minNumber Lowest number to generate.
     * @return the randomly generated number.
     */
    public static int randomValue(int maxNumber, int minNumber) {
        // create instance of Random class
        Random rand = new Random();

        // Generate random integers in range 0 to 9
        return rand.nextInt(maxNumber + 1 - minNumber) + minNumber;
    }

    @SuppressLint({"SetTextI18n", "UseCompatLoadingForDrawables"})
    // Unclear why this is needed, but it is.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // GUI Elements
        ImageView imageView = findViewById(R.id.blackBox);
        ImageView mapView = findViewById(R.id.mapImage);
        final Button end = findViewById(R.id.endButton);
        final Button map = findViewById(R.id.mapButton);
        final Button wagonButton = findViewById(R.id.wagonButton);
        final Button stats = findViewById(R.id.statsButton);
        final Button start = findViewById(R.id.startButton);
        final TextView display = findViewById(R.id.statsDisplay);
        final TextView location = findViewById(R.id.locationText);
        final TextView title = findViewById(R.id.oregonWelcome);
        ImageView model = findViewById(R.id.person);

        final Button storeButton = findViewById(R.id.storeButton);
        ImageView white = findViewById(R.id.imageView2);
        final TextView bulletCount = findViewById(R.id.bulletText);
        final TextView foodCount = findViewById(R.id.foodText);
        final TextView waterCount = findViewById(R.id.waterText);
        final TextView clothesCount = findViewById(R.id.clothesText);
        final ImageButton food = findViewById(R.id.breadButton);
        final ImageButton water = findViewById(R.id.waterButton);
        final ImageButton clothes = findViewById(R.id.clothesButton);
        final ImageButton bullet = findViewById(R.id.bulletButton);
        final Button exit = findViewById(R.id.exitButton);
        final TextView shop = findViewById(R.id.SHOP);
        final TextView smallShop = findViewById(R.id.shopTextSmall);
        final Button buy = findViewById(R.id.BUY);


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
        Towns.add(new Place("Independence Rock, Wyoming", 160));
        Towns.add(new Place("Oregon", 200));

        // Random Events
        ArrayList<Event> Events = new ArrayList<>();
        Events.add(new CholeraEvent(1));
        Events.add(new DysenteryEvent(1));
        Events.add(new SuppliesEvent(1));
        Events.add(new TheftEvent(1));


        // Wagon
        Wagon wagon = new Wagon(items, 1000, 6, people);

        // Controls start button.
        start.setOnClickListener(view -> {

            // Code to hide start button goes here
            final int[] day = {0};
            start.setVisibility(View.INVISIBLE);
            model.setVisibility(View.INVISIBLE);

            // Hides shop
            imageView.setVisibility(View.INVISIBLE);
            white.setVisibility(View.INVISIBLE);
            bulletCount.setVisibility(View.INVISIBLE);
            foodCount.setVisibility(View.INVISIBLE);
            waterCount.setVisibility(View.INVISIBLE);
            clothesCount.setVisibility(View.INVISIBLE);
            food.setVisibility(View.INVISIBLE);
            water.setVisibility(View.INVISIBLE);
            clothes.setVisibility(View.INVISIBLE);
            bullet.setVisibility(View.INVISIBLE);
            exit.setVisibility(View.INVISIBLE);
            shop.setVisibility(View.INVISIBLE);
            smallShop.setVisibility(View.INVISIBLE);
            buy.setVisibility(View.INVISIBLE);


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

                        for (int i2 = 0; i2 < wagon.getPeople().size(); i2++) {
                            wagon.getPeople().get(i).setEmotion(Person.Emotion.SAD);
                        }

                        if (person.getName().equals("Hattie Campbell")) {
                            display.setText("Hattie Campbell died on day " + day[0] + ".\nGAME OVER");
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

                        if(Towns.get(i).getName().equals("Oregon")) {
                            for (int i2 = 0; i2 < wagon.getPeople().size(); i2++) {
                                wagon.getPeople().get(i2).setEmotion(Person.Emotion.HAPPY);
                            }

                            display.setText("You made it to Oregon!\nGAME OVER");
                            // TODO: Reset game
                            break;
                        }

                        break;
                    }
                }

                if (randomValue(10, 1) == 1 && !inCity) {
                    display.setText(Events.get(randomValue(Events.size() - 1, 0)).onEvent(wagon));
                }

                // Emotion code
                // Runs through and checks emotion
                Person.Emotion emotion = hattie.getEmotion(); // Gets Emotion

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
                mapView.setVisibility(View.VISIBLE);
                display.setVisibility(View.INVISIBLE);
                model.setVisibility(View.INVISIBLE);
            });

            // Controls the stats display.
            stats.setOnClickListener(view12 -> {
                mapView.setVisibility(View.INVISIBLE);
                model.setVisibility(View.VISIBLE);
                // Displays stats
                display.setText("Hattie Campbell Stats = Health: " + hattie.getHealth() + "\nThirst: " + hattie.getThirst() + "\nHunger: " + hattie.getHunger() + "\nMood: " + hattie.getEmotion());
                display.setVisibility(View.VISIBLE);
            });
        });

        // Controls the wagon display.
        wagonButton.setOnClickListener(view12 -> {
            mapView.setVisibility(View.INVISIBLE);
            model.setVisibility(View.VISIBLE);
            // Displays wagon stats
            display.setText("Wagon Stats = Ammo: " + wagon.getItem("Ammo").getCount() + "\nClothes: " + wagon.getItem("Clothes").getCount() + "\nFood: " + wagon.getItem("Food").getCount() + "\nMedical Supplies: " + wagon.getItem("Medical Supplies").getCount() + "\nWater: " + wagon.getItem("Water").getCount());
            display.setVisibility(View.VISIBLE);



        });

        storeButton.setOnClickListener(view12 -> {

            imageView.setVisibility(View.VISIBLE);
            white.setVisibility(View.VISIBLE);
            bulletCount.setVisibility(View.VISIBLE);
            foodCount.setVisibility(View.VISIBLE);
            waterCount.setVisibility(View.VISIBLE);
            clothesCount.setVisibility(View.VISIBLE);
            food.setVisibility(View.VISIBLE);
            water.setVisibility(View.VISIBLE);
            clothes.setVisibility(View.VISIBLE);
            bullet.setVisibility(View.VISIBLE);
            exit.setVisibility(View.VISIBLE);
            shop.setVisibility(View.VISIBLE);
            smallShop.setVisibility(View.VISIBLE);
            buy.setVisibility(View.VISIBLE);

            //hide
            model.setVisibility(View.INVISIBLE);
            storeButton.setVisibility(View.INVISIBLE);
            display.setVisibility(View.INVISIBLE);
            wagonButton.setVisibility(View.INVISIBLE);
            start.setVisibility(View.INVISIBLE);
            end.setVisibility(View.INVISIBLE);
            stats.setVisibility(View.INVISIBLE);
            location.setVisibility(View.INVISIBLE);
            title.setVisibility(View.INVISIBLE);
            mapView.setVisibility(View.INVISIBLE);
            map.setVisibility(View.INVISIBLE);


        });
        exit.setOnClickListener(view12 -> {

            //Displays StartScreen
            model.setVisibility(View.VISIBLE);
            storeButton.setVisibility(View.VISIBLE);
            display.setVisibility(View.VISIBLE);
            wagonButton.setVisibility(View.VISIBLE);
            end.setVisibility(View.VISIBLE);
            stats.setVisibility(View.VISIBLE);
            location.setVisibility(View.VISIBLE);
            title.setVisibility(View.VISIBLE);

            map.setVisibility(View.VISIBLE);

            // Hides Shop
            imageView.setVisibility(View.INVISIBLE);
            white.setVisibility(View.INVISIBLE);
            bulletCount.setVisibility(View.INVISIBLE);
            foodCount.setVisibility(View.INVISIBLE);
            waterCount.setVisibility(View.INVISIBLE);
            clothesCount.setVisibility(View.INVISIBLE);
            food.setVisibility(View.INVISIBLE);
            water.setVisibility(View.INVISIBLE);
            clothes.setVisibility(View.INVISIBLE);
            bullet.setVisibility(View.INVISIBLE);
            exit.setVisibility(View.INVISIBLE);
            shop.setVisibility(View.INVISIBLE);
            smallShop.setVisibility(View.INVISIBLE);
            buy.setVisibility(View.INVISIBLE);

        });
        // Buy button
        buy.setOnClickListener(view12 -> {
            //Displays StartScreen
            model.setVisibility(View.VISIBLE);
            storeButton.setVisibility(View.VISIBLE);
            display.setVisibility(View.VISIBLE);
            wagonButton.setVisibility(View.VISIBLE);
            end.setVisibility(View.VISIBLE);
            stats.setVisibility(View.VISIBLE);
            location.setVisibility(View.VISIBLE);
            title.setVisibility(View.VISIBLE);

            map.setVisibility(View.VISIBLE);

            // Hides Shop
            imageView.setVisibility(View.INVISIBLE);
            white.setVisibility(View.INVISIBLE);
            bulletCount.setVisibility(View.INVISIBLE);
            foodCount.setVisibility(View.INVISIBLE);
            waterCount.setVisibility(View.INVISIBLE);
            clothesCount.setVisibility(View.INVISIBLE);
            food.setVisibility(View.INVISIBLE);
            water.setVisibility(View.INVISIBLE);
            clothes.setVisibility(View.INVISIBLE);
            bullet.setVisibility(View.INVISIBLE);
            exit.setVisibility(View.INVISIBLE);
            shop.setVisibility(View.INVISIBLE);
            smallShop.setVisibility(View.INVISIBLE);
            buy.setVisibility(View.INVISIBLE);
        });

        // Food button
        food.setOnClickListener(view12 -> {
            int count =0;
            count++;
            foodCount.setText("Food: " + count);
        });

        // Clothes button
        clothes.setOnClickListener(view12 -> {
            int count =0;
            count++;
            clothesCount.setText("Clothes: " + count);
        });

        // Bullets button
        bullet.setOnClickListener(view12 -> {
            int count =0;
            count++;
            bulletCount.setText("Ammo: " + count);
        });

        // Water button
        water.setOnClickListener(view12 -> {
            int count =0;
            count++;
            waterCount.setText("Water: " + count);
        });
    }
}
