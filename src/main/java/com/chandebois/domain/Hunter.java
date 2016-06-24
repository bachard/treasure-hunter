package com.chandebois.domain;

import com.chandebois.orientation.Orientation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nonok on 24/06/2016.
 */
public class Hunter {

    private Position position;
    private Orientation orientation;
    private List<Treasure> treasures;

    public Hunter(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
        treasures = new ArrayList<>();
    }

    public void addTreasure(Treasure treasureFound) {
        treasures.add(treasureFound);
        //implements a notifier for the number of treasures found
    }

    public void forward() {
        this.position = orientation.forward(this.position);
        //implements notifier for hunter position
    }

    public void turnLeft() {
        this.orientation = this.orientation.turnLeft();
    }

    public void turnRight() {
        this.orientation = this.orientation.turnRight();
    }

    public int getAmountOfTreasuresCollected() {
        return this.getTreasures().size();
    }

    public Position getPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public List<Treasure> getTreasures() {
        return treasures;
    }
}
