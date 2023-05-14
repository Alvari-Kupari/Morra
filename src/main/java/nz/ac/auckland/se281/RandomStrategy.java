package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

    @Override
    public int[] decide() {
        // this method chooses the sum randomly
        int fingers = Utils.getRandomNumber(1, 5);
        int sum = Utils.getRandomNumber(fingers + 1, fingers + 5);

        // format the selection
        int[] selection = { fingers, sum };
        return selection;
    }
}
