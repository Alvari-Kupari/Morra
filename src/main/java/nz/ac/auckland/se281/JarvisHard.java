package nz.ac.auckland.se281;

public class JarvisHard extends Jarvis {

  public JarvisHard() {
    // start with random
    this.strategy = new RandomStrategy();
  }

  @Override
  public void updateStrategy(Status status) {
    if (status.getRounds() == 3) {
      // if at least 3 games have been played then update the strategy to Top
      strategy = new TopStrategy(status);

    }
  }
}
