package nz.ac.auckland.se281;

//this class contains several helper methods

public class MyUtils {

  public static boolean isValidGameInput(String input) {
    // this method checks whether the user correctly formatted their inputs for the
    // game

    // first check if the string is empty or null
    if (input == null || input.length() == 0) {
      return false;
    }

    // next we must split the string into 2 parts, separated by a space
    String[] arguments = input.split(" ", 2);

    // check if it was correctly split
    if (arguments.length != 2) {
      return false;
    }

    // next check if both strings are integers
    if (!Utils.isInteger(arguments[0]) || !Utils.isInteger(arguments[1])) {
      return false;
    }

    // convert the strings to numbers
    int fingers = Integer.parseInt(arguments[0]);
    int sum = Integer.parseInt(arguments[1]);

    // next check if the numbers are in the correct ranges
    if (fingers <= 5 && fingers >= 1 && sum >= 1 && sum <= 10) {
      // if so the result must be valid
      return true;
    }
    // otherwise it must be invalid
    return false;
  }

  public static String getInput() {
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
    return input;
  }

  public static int[] splitString(String s) {
    // this method splits a string containing 2 numbers into 2 separate numbers

    // first split the string
    String[] splitString = s.split(" ", 2);

    // separate the two and convert them to integers
    int a = Integer.parseInt(splitString[0]);
    int b = Integer.parseInt(splitString[1]);

    int[] array = { a, b };

    // return the result
    return array;
  }
}
