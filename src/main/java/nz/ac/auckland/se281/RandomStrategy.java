package nz.ac.auckland.se281;

import java.util.ArrayList;

public class RandomStrategy implements Strategy {

    @Override
    public int[] decide() {
        // this method chooses the sum randomly
        int fingers = Utils.getRandomNumber(1, 5);
        int sum = Utils.getRandomNumber(fingers + 1, fingers + 5);

        int[] selection = { fingers, sum };
        return selection;
    }
}
