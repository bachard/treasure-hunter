package com.chandebois.orientation;

import com.chandebois.domain.Position;

/**
 * Created by nonok on 22/06/2016.
 */
public class OrientationSouth implements Orientation {
    @Override
    public Position forward(final Position position) {
        Position nextPosition = new Position();
        nextPosition.setCoordX(position.getCoordX());
        nextPosition.setCoordY(position.getCoordY() - 1);
        return nextPosition;
    }

    @Override
    public Orientation turnLeft() {
        return new OrientationEast();
    }

    @Override
    public Orientation turnRight() {
        return new OrientationWest();
    }
}
