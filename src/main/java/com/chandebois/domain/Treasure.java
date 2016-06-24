package com.chandebois.domain;

/**
 * Created by nonok on 24/06/2016.
 */
public class Treasure implements Cloneable{

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

    public Object clone() {
        Treasure treasure = null;
        try {
            treasure = (Treasure) super.clone();
        } catch (CloneNotSupportedException cnse) {

        }
        return treasure;
    }

    @Override
    public boolean equals(Object o) {
        boolean isEquals = false;
        if (o == null) {
            isEquals = false;
        } else if (o == this) {
            isEquals = true;
        } else {
            if (o instanceof Treasure) {
                Treasure t = (Treasure) o;
                isEquals = t.getPosition().equals(this.getPosition()) && t.getValue() == this.value;
            }
        }
        return isEquals;
    }
}
