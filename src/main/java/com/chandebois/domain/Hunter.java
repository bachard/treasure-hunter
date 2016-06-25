package com.chandebois.domain;

import com.chandebois.orientation.Orientation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nonok on 24/06/2016.
 */
public class Hunter {

    private String name;
    private Position position;
    private Orientation orientation;
    private TreasureMap treasureMap;
    private List<Treasure> treasures;

    private Hunter(HunterBuilder hunterBuilder) {
        this.name = hunterBuilder.name;
        this.position = hunterBuilder.position;
        this.orientation = hunterBuilder.orientation;
        this.treasureMap = hunterBuilder.treasureMap;
        this.treasures = hunterBuilder.treasures;
    }

    public static class HunterBuilder {
        private String name;
        private Position position;
        private Orientation orientation;
        private TreasureMap treasureMap;
        private List<Treasure> treasures;

        public HunterBuilder(Position position, Orientation orientation, TreasureMap treasureMap) {
            this.position = position;
            this.orientation = orientation;
            this.treasureMap = treasureMap;
            this.treasures = new ArrayList<>();
        }

        public HunterBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Hunter build() {
            return new Hunter(this);
        }

    }

    public void addTreasure(Treasure treasureFound) {
        treasures.add(treasureFound);
        //implements a notifier for the number of treasures found
    }

    public void forward() {
        Position nextPosition = orientation.forward(this.position);
        if (treasureMap.isPositionInsideMap(nextPosition) && !treasureMap.isPositionContainsMoutain(nextPosition)) {
            this.position = nextPosition;
            //implements notifier for hunter position
            if (treasureMap.isPositionContainsTreasure(this.position)) {
                treasures.add(treasureMap.collectTreasure(this.position));
            }
        }

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
