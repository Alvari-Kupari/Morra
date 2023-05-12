package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private int numMatches;
  private Jarvis jarvis;
  private Human human;
  private ArrayList<Integer> fingersHistory = new ArrayList<>();

  public Morra() {
    this.numMatches = 0;

  }

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);

    // create the opponent based on difficulty given
    this.jarvis = JarvisFactory.createJarvis(difficulty);

    // create the human player
    this.human = new Human(options[0]);
  }

  public void play() {
    // increment numMatches and print the start round message
    this.numMatches++;
    MessageCli.START_ROUND.printMessage(Integer.toString(this.numMatches));

    // both players can now play
    int[] humanChoice = human.play();
    int[] jarvisChoice = jarvis.play();

    // print both hands
    printHands(human.getName(), humanChoice[0], humanChoice[1], jarvisChoice[0], jarvisChoice[1]);

    // print the result
    getResult(jarvisChoice, humanChoice);
  }

  public void showStats() {
  }

  public void getResult(int[] jarvis, int[] human) {
    // this method determines who wins and prints the correct message
    int totalSum = jarvis[0] + human[0];

    if (jarvis[1] == totalSum) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
    } else if (human[1] == totalSum) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }
  }

  public void printHands(String playerName, int fingers, int sum, int jarvisFingers, int jarvisSum) {
    // this method prints both hands
    MessageCli.PRINT_INFO_HAND.printMessage(playerName, Integer.toString(fingers), Integer.toString(sum));
    MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", Integer.toString(jarvisFingers), Integer.toString(jarvisSum));
  }
}
