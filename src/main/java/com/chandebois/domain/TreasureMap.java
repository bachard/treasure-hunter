package com.chandebois.domain;

/**
 * Created by nonok on 24/06/2016.
 */
public class TreasureMap {

    private int width;
    private int height;

    public TreasureMap() {
    }

    public TreasureMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
