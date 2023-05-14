package nz.ac.auckland.se281;

public class JarvisMaster extends Jarvis {
  private boolean cycle;

  public JarvisMaster() {
    // begin with random
    this.strategy = new RandomStrategy();
    this.cycle = true;
  }

  @Override
  public void updateStrategy(Morra morra) {
    // check if at least 3 rounds have been played
    if (morra.getNumMatches() >= 3) {
      // if so switch between the cycles
      if (cycle) {
        this.strategy = new AverageStrategy(morra);
      } else {
        this.strategy = new TopStrategy(morra);
      }
      // negate the cycle
      this.cycle = !this.cycle;
    }
  }
}
