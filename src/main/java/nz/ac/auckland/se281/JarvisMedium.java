package nz.ac.auckland.se281;

public class JarvisMedium extends Jarvis {

    public JarvisMedium() {
        // initialise strategy to be random
        this.strategy = new RandomStrategy();
    }

    @Override
    public void updateStrategy(Morra morra) {
        if (morra.getNumMatches() == 3) {
            strategy = new AverageStrategy(morra);

        }
    }
}
