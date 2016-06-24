package com.chandebois.domain;

/**
 * Created by nonok on 22/06/2016.
 */
public class Position {
    //to refactor not a domain class ??
    public Position() {
        this.coordX = 1;
        this.coordY = 1;
    }

    public Position(int coordX, int coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    private int coordX;
    private int coordY;

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    @Override
    public boolean equals(Object o) {
        boolean isEquals = false;
        if (o == null) {
            isEquals = false;
        } else if (o == this) {
            isEquals = true;
        } else {
            if (o instanceof Position) {
                Position p = (Position) o;
                isEquals = p.getCoordX() == this.coordX && p.getCoordY() == this.coordY;
            }
        }
        return isEquals;
    }
}
