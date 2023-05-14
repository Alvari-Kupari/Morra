package nz.ac.auckland.se281;

public class JarvisMaster extends Jarvis {
    public boolean cycle;

    public JarvisMaster() {
        // begin with random
        this.strategy = new RandomStrategy();
        this.cycle = true;
    }

    @Override
    public void updateStrategy(Morra morra) {
        if (morra.getNumMatches() >= 3) {
            if (cycle) {
                this.strategy = new AverageStrategy(morra);
            } else {
                this.strategy = new TopStrategy(morra);
            }
            this.cycle = !this.cycle;
        }
    }
}
