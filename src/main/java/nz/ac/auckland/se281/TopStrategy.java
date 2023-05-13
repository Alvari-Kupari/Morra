package nz.ac.auckland.se281;

import java.util.ArrayList;

public class TopStrategy implements Strategy {

    public Morra morra;

    public TopStrategy(Morra morra) {
        this.morra = morra;
    }

    public int[] decide() {
        // initialise the arraylist
        ArrayList<Integer> fingersHistory = morra.getFingersHistory();

        // guess the number of fingers
        int fingers = Utils.getRandomNumber(1, 5);

        // now lets find the most common values
        int top = fingersHistory.get(0);

        // initialise the max number of occurences
        int maxCount = getOccurences(fingersHistory.get(0), fingersHistory);

        // loop through the array list and update if an element with a higher coutn is
        // found
        for (int i = 1; i < fingersHistory.size(); i++) {
            int count = getOccurences(fingersHistory.get(i), fingersHistory);
            if (count > maxCount) {
                maxCount = count;
                top = fingersHistory.get(i);
            }
        }

        int sum = fingers + top;

        // return the selection

        int[] selection = { fingers, sum };
        return selection;
    }

    public int getOccurences(int a, ArrayList<Integer> fingerHistory) {
        int count = 0;
        for (int i = 0; i < fingerHistory.size(); i++) {
            if (fingerHistory.get(i) == a) {
                count++;
            }
        }
        return count;
    }

}
