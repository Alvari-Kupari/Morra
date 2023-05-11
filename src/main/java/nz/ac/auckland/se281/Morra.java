package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {
  private int numMatches;
  private String playerName;
  private Jarvis jarvis;

  public Morra() {
    this.numMatches = 0;

  }

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);

    // add the player name to the game
    this.playerName = options[0];

    // create the opponent based on difficulty given
    this.jarvis = JarvisFactory.createJarvis(difficulty);
  }

  public void play() {
    // increment numMatches and print the start round message
    this.numMatches++;
    MessageCli.START_ROUND.printMessage(Integer.toString(this.numMatches));

    // next we must get the number of fingers and sum from the user
    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();

    // next ensure the input is valid
    while (!MyUtils.isValidGameInput(input)) {

      // print the error message for invalid input
      MessageCli.INVALID_INPUT.printMessage();

      // ask for new input
      input = Utils.scanner.nextLine();
    }

    // now lets extract the numbers from the arguments provided
    int fingers = MyUtils.splitString(input)[0];
    int sum = MyUtils.splitString(input)[1];

    // print the successfully formatted commands
    MessageCli.PRINT_INFO_HAND.printMessage(this.playerName, Integer.toString(fingers), Integer.toString(sum));

    // jarvis will choose their sum and fingers
    this.jarvis.select();

  }

  public void showStats() {
  }
}
