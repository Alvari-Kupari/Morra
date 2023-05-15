package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Status {
    // this class contains game information in an object that can be shipped off
    private ArrayList<Integer> fingersHistory;
    private int numRounds;

    public Status(int numRounds) {
        this.numRounds = numRounds;
        this.fingersHistory = new ArrayList<Integer>();

    }

    public int getRounds() {
        // thus method gets the number of rounds
        return this.numRounds;
    }

    public void setRounds(int numRounds) {
        // this method is a setter
        this.numRounds = numRounds;
    }

    public void incrementRounds() {
        // this method updates the number of rounds
        this.numRounds++;
    }

    public ArrayList<Integer> getFingersHistory() {
        // this method returns an arraylist containing the previous plays made
        return this.fingersHistory;
    }

    public void updateHistory(int fingersPlayed) {
        this.fingersHistory.add(fingersPlayed);
    }

    public void clearHistory() {
        if (fingersHistory == null) {
            return;
        }
        fingersHistory.clear();
    }
}
