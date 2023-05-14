package nz.ac.auckland.se281;

public class Human {
    private String name;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int[] play() {
        // this method gets the input from the user and saves it into the game

        // next we must get the number of fingers and sum from the user
        String input = MyUtils.getInput();

        // now lets extract the numbers from the arguments provided
        int fingers = MyUtils.splitString(input)[0];
        int sum = MyUtils.splitString(input)[1];

        // format the selection
        int[] choice = { fingers, sum };
        return choice;

    }

}
