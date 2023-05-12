package nz.ac.auckland.se281;

import java.util.ArrayList;

public abstract class Jarvis {

    protected Strategy strategy;

    public int[] play() {
        return strategy.decide();
    }

}
