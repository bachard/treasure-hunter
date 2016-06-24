package com.chandebois.domain;

/**
 * Created by nonok on 22/06/2016.
 */
public class Position {

    public Position(){

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
}
