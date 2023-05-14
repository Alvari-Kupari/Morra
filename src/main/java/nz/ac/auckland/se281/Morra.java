package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private int numMatches;
  private Jarvis jarvis;
  private Human human;
  private ArrayList<Integer> fingersHistory = new ArrayList<>();

  public Morra() {
    this.numMatches = -1;
  }

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);

    // create the opponent based on difficulty given
    this.jarvis = JarvisFactory.createJarvis(difficulty);

    // create the human player
    this.human = new Human(options[0]);

    // reset the number of matches and wipe the history of plays
    this.numMatches = 0;
    fingersHistory.clear();

  }

  public void play() {
    // first check if there is a game
    if (numMatches == -1) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    // increment numMatches and print the start round message
    this.numMatches++;
    MessageCli.START_ROUND.printMessage(Integer.toString(this.numMatches));

    // both players can now play
    int[] humanChoice = human.play();
    int[] jarvisChoice = jarvis.play();

    // print the result
    getResult(human.getName(), jarvisChoice, humanChoice);

    // add the humans choice to the database
    fingersHistory.add(humanChoice[0]);

    // update new stratgies
    jarvis.updateStrategy(this);
  }

  public void showStats() {

  }

  public void getResult(String playerName, int[] jarvis, int[] human) {
    // this method determines who wins and prints the correct message

    // this method also prints both hands
    MessageCli.PRINT_INFO_HAND.printMessage(playerName, Integer.toString(human[0]), Integer.toString(human[1]));
    MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", Integer.toString(jarvis[0]), Integer.toString(jarvis[1]));

    int totalSum = jarvis[0] + human[0];
    // first check if both players got it right
    if (jarvis[1] == totalSum && human[1] == totalSum) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    } else if (jarvis[1] == totalSum) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
    } else if (human[1] == totalSum) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }
  }

  public ArrayList<Integer> getFingersHistory() {
    return this.fingersHistory;
  }

  public int getNumMatches() {
    return this.numMatches;
  }

}
