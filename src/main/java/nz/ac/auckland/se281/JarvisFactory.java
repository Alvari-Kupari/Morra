package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class JarvisFactory {
    public static Jarvis createJarvis(Difficulty difficulty) {
        // this class creates a jarvis based on the difficulty
        switch (difficulty) {
            case EASY:
                // make a new easy jarvis
                return new JarvisEasy();

            case MEDIUM:
                // make a new medium jarvis
                return new JarvisMedium();

            case HARD:
                // make a new hard jarvis
                return new JarvisHard();

            case MASTER:
                // make a new master jarvis
                return new JarvisMaster();

            default:
                return null;
        }
    }
}
