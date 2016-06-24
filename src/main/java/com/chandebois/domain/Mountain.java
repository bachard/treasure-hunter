package com.chandebois.domain;

/**
 * Created by nonok on 24/06/2016.
 */
public class Mountain {

    public Mountain() {
    }

    public Mountain(Position position) {
        this.position = position;
    }

    private Position position;

    public Position getPosition() {
        return position;
    }
}
