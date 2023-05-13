package nz.ac.auckland.se281;

public abstract class Jarvis {

    protected Strategy strategy;

    public int[] play() {

        return strategy.decide();
    }

    public void updateStrategy(Morra morra) {
    }
    /*
     * public void updateStrategy(Morra morra) {
     * if (morra.getNumMatches() == 3) {
     * if (this instanceof JarvisMedium) {
     * strategy = new AverageStrategy(morra);
     * }
     * }
     * }
     */

}
