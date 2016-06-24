package com.chandebois.orientation;

import com.chandebois.domain.Position;

/**
 * Created by nonok on 22/06/2016.
 */
public interface Orientation {

    Position forward(final Position position);

    Orientation turnLeft();

    Orientation turnRight();
}
