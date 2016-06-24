package com.chandebois.orientation;

import com.chandebois.domain.Position;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nonok on 22/06/2016.
 */
public class OrientationNorthUnitTest {

    private Orientation orientation;

    @Before
    public void setUp() throws Exception {
        orientation = new OrientationNorth();
    }

    @Test
    public void should_forward_of_1_on_x_axis() throws Exception {
        //Given
        Position position = new Position(2, 2);
        //When
        Position nextPosition = orientation.forward(position);
        //Then
        Assertions.assertThat(nextPosition.getCoordY()).isEqualTo(1);
    }

    @Test
    public void should_turn_left_to_west_when_north() throws Exception {
        //When
        Orientation nextOrientation = orientation.turnLeft();
        //Then
        Assertions.assertThat(nextOrientation).isInstanceOf(OrientationWest.class);
    }

    @Test
    public void should_turn_right_to_east_when_north() throws Exception {
        //When
        Orientation nextOrientation = orientation.turnRight();
        //Then
        Assertions.assertThat(nextOrientation).isInstanceOf(OrientationEast.class);
    }
}
