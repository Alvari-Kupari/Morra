package nz.ac.auckland.se281;

public class JarvisHard extends Jarvis {

    public JarvisHard() {
        // start with random
        this.strategy = new RandomStrategy();
    }

    @Override
    public void updateStrategy(Morra morra) {
        if (morra.getNumMatches() == 3) {
            strategy = new TopStrategy(morra);

        }
    }
}
