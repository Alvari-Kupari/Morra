package nz.ac.auckland.se281;

public class JarvisMedium extends Jarvis {

    public JarvisMedium() {
        // initialise strategy to be random
        this.strategy = new RandomStrategy();
    }

    @Override
    public void updateStrategy(Morra morra) {
        if (morra.getNumMatches() == 3) {
            // if at least 3 games have bene played then go to average strat
            strategy = new AverageStrategy(morra);

        }
    }
}
