package com.example.oregontrail;

/**
 * Making this was a mistake. Avoid using this class.
 */
@Deprecated
public class Emotion {

    private static final char[] emotions = {'A', 'H', 'I', 'N', 'S'}; // A = Angry, H = Happy, I = Ill, N = Neutral, S = Sad
    private char mood; // Current Mood

    /**
     * Creates an emotion?
     * @param mood The char value corresponding to the current mood. Possible values include A, H, I, N, S.
     */
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
