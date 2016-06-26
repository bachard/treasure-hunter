package com.chandebois.orientation;

import com.chandebois.domain.Position;

/**
 * Created by nonok on 22/06/2016.
 */
public class OrientationEast implements Orientation {

    @Override
    public Position forward(final Position position) {
        Position nextPosition = new Position();
        nextPosition.setCoordX(position.getCoordX() + 1);
        nextPosition.setCoordY(position.getCoordY());
        return nextPosition;
    }

    @Override
    public Orientation turnLeft() {
        return new OrientationNorth();
    }

    @Override
    public Orientation turnRight() {
        return new OrientationSouth();
    }

    @Override
    public String toString() {
        return "East orientation";
    }
}
