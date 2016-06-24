package com.chandebois.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by nonok on 24/06/2016.
 */
public class TreasureMap {

    private int width;
    private int height;
    private List<Treasure> treasures;
    private List<Mountain> mountains;

    public TreasureMap(final int width, final int height) {
        this.width = width;
        this.height = height;
        this.treasures = new ArrayList<>();
        this.mountains = new ArrayList<>();
    }

    public void addTreasure(final Treasure treasure) {
        this.treasures.add(treasure);
    }

    public void addMountain(final Mountain moutain) {
        this.mountains.add(moutain);
    }

    public boolean isInsideMap(final Position position) {
        return IntStream.rangeClosed(1, this.width).anyMatch(c -> c == position.getCoordX())
                && IntStream.rangeClosed(1, this.height).anyMatch(c -> c == position.getCoordY());
    }

    public boolean isCellContainsMoutain(final Position position) {
        for (Mountain mountain : mountains) {
            if (mountain.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCellContainsTreasure(final Position position) {
        for (Treasure treasure : treasures) {
            if (treasure.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    public Treasure collectTreasure(final Position position) {
        Treasure treasureToCollect = null;
        for (Treasure treasure : treasures) {
            if (treasure.getPosition().equals(position)) {
                treasureToCollect = (Treasure) treasure.clone();
            }
        }
        removeTreasure(treasureToCollect);
        return treasureToCollect;
    }

    private void removeTreasure(final Treasure treasure) {
        this.treasures.remove(treasure);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Treasure> getTreasures() {
        return treasures;
    }

    public List<Mountain> getMountains() {
        return mountains;
    }
}
