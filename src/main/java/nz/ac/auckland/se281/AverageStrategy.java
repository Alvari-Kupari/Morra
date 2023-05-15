package nz.ac.auckland.se281;

import java.util.ArrayList;

public class AverageStrategy implements Strategy {
    private Status status;

    public AverageStrategy(Status status) {
        this.status = status;
    }

    public int[] decide() {
        ArrayList<Integer> fingersHistory = status.getFingersHistory();

        // get the sum of the elements
        int sum = 0;

        // loop through and find the total sum
        for (int i : fingersHistory) {
            sum += i;
        }

        // randomly generate fingers
        int fingers = Utils.getRandomNumber(1, 5);

        // find the average
        float avg = (float) sum / fingersHistory.size();

        // round the result
        int sumGuess = Math.round(avg) + fingers;

        // formate the selection
        int[] selection = { fingers, sumGuess };
        return selection;
    }

}
