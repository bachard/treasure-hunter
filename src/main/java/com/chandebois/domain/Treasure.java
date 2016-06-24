package com.chandebois.domain;

/**
 * Created by nonok on 24/06/2016.
 */
public class Treasure {

    public Treasure() {
    }

    public Treasure(Position position, int value) {
        this.position = position;
        this.value = value;
    }

    private Position position;
    private int value;

    public Position getPosition() {
        return position;
    }

    public int getValue() {
        return value;
    }
}
