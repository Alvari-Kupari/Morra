package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

    @Override
    public int chooseFingers() {
        // this method randomly selects a number of fingers between 1 and 5
        return Utils.getRandomNumber(1, 5);
    }

    @Override
    public int chooseSum(int fingers) {
        return Utils.getRandomNumber(fingers + 1, fingers + 5);
    }
}
