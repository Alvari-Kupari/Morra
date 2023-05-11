package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class JarvisFactory {
    public static Jarvis createJarvis(Difficulty difficulty) {
        switch (difficulty) {
            case EASY:
                return new JarvisEasy();

            default:
                return null;
        }
    }
}
