package nz.ac.auckland.se281;

import java.util.ArrayList;

public class AverageStrategy implements Strategy {
    private Morra morra;

    public AverageStrategy(Morra morra) {
        this.morra = morra;
    }

    public int[] decide() {
        ArrayList<Integer> fingersHistory = morra.getFingersHistory();

        // get the sumof the elements
        int sum = 0;
        for (int i : fingersHistory) {
            sum += i;
        }
        // then find averaage and round

        // randomly generate fingers
        int fingers = Utils.getRandomNumber(1, 5);

        // find the average
        float avg = (float) sum / fingersHistory.size();

        // round the result
        int sumGuess = Math.round(avg) + fingers;

        int[] selection = { fingers, sumGuess };
        return selection;
    }

}
