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
        return IntStream.rangeClosed(0, this.width).anyMatch(c -> c == position.getCoordX())
                && IntStream.rangeClosed(0, this.height).anyMatch(c -> c == position.getCoordY());
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
