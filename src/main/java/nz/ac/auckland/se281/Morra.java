package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private Jarvis jarvis;
  private Human human;
  private int pointToWin;
  private int jarvisWins;
  private int playerWins;
  private Status status;

  public Morra() {
    this.pointToWin = -1;
    this.status = new Status(-1);

  }

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);

    // reset the game
    reset();

    // create the opponent based on difficulty given
    this.jarvis = JarvisFactory.createJarvis(difficulty);

    // create the human player
    this.human = new Human(options[0]);

    // save the points to win
    this.pointToWin = pointsToWin;

  }

  public void play() {
    // first check if there is a game
    if (status.getRounds() == -1) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    // increment numMatches and print the start round message
    status.incrementRounds();
    MessageCli.START_ROUND.printMessage(Integer.toString(status.getRounds()));

    // both players can now play
    int[] humanChoice = human.play();
    int[] jarvisChoice = jarvis.play();

    // print the result
    getResult(human.getName(), jarvisChoice, humanChoice);

    // now check if the game is over
    if (gameOver()) {
      return;
    }

    // add the humans choice to the database
    status.updateHistory(humanChoice[0]);

    // update new stratgies
    jarvis.updateStrategy(status);
  }

  public void showStats() {
    // first ensure there is a game
    if (status.getRounds() == -1) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // print the stats for jarvis
    MessageCli.PRINT_PLAYER_WINS.printMessage("Jarvis", Integer.toString(jarvisWins),
        Integer.toString(pointToWin - jarvisWins));

    // print the stats for the player
    MessageCli.PRINT_PLAYER_WINS.printMessage(human.getName(), Integer.toString(playerWins),
        Integer.toString(pointToWin - playerWins));

  }

  public void getResult(String playerName, int[] jarvis, int[] human) {
    // this method determines who wins and prints the correct message

    // this method also prints both hands
    MessageCli.PRINT_INFO_HAND.printMessage(playerName, Integer.toString(human[0]), Integer.toString(human[1]));
    MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", Integer.toString(jarvis[0]), Integer.toString(jarvis[1]));

    // find the actual sum
    int totalSum = jarvis[0] + human[0];

    // establish who won
    boolean jarvisWon = jarvis[1] == totalSum;
    boolean humanWon = human[1] == totalSum;

    // find out what the message should be
    String result;

    if (jarvisWon && !humanWon) {
      result = "AI_WINS";

      // then update the stats for jarvis
      this.jarvisWins++;

    } else if (!jarvisWon && humanWon) {
      result = "HUMAN_WINS";

      // then update the number of player wins
      this.playerWins++;

    } else {
      result = "DRAW";
    }
    // now print who won
    MessageCli.PRINT_OUTCOME_ROUND.printMessage(result);

  }

  public void reset() {

    // reset the match
    this.jarvisWins = 0;
    this.playerWins = 0;
    status.setRounds(0);
    status.clearHistory();
  }

  public void finishGame() {
    // this method resets the game once a game is finished
    status.setRounds(-1);
    this.pointToWin = -1;
  }

  public boolean gameOver() {
    // find out if someone has won
    boolean jarvisWon = pointToWin == jarvisWins;
    boolean humanWon = pointToWin == playerWins;

    // if neither won then exit and return false
    if (!jarvisWon && !humanWon) {
      return false;
    }

    // now find the correct string for the player who won
    String playerWon = jarvisWon ? "Jarvis" : human.getName();

    // print the end game message and exit
    MessageCli.END_GAME.printMessage(playerWon, Integer.toString(status.getRounds()));

    // reset all stats
    reset();

    // then finish the game
    finishGame();

    return true;

  }
}
