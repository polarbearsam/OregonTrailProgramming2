package com.example.oregontrail;

import java.util.ArrayList;

public class Emotion {

    private static final char[] emotions = {'A', 'H', 'I', 'N', 'S'};
    private char mood;

    public Emotion(char mood) {
        if (!setMood(mood)) {
            setMood('N');
        }
    }

    public char getMood() {
        return mood;
    }

    public boolean setMood(char mood) {
        for (char emotion : emotions) {
            if (mood == emotion) {
                this.mood = mood;
                return true;
            }
        }
        return false;
    }
}
