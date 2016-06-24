package com.chandebois.orientation;

import com.chandebois.domain.Position;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nonok on 22/06/2016.
 */
public class OrientationEastUnitTest {

    private Orientation orientation;

    @Before
    public void setUp() throws Exception {
        orientation = new OrientationEast();
    }

    @Test
    public void should_forward_of_1_on_x_axis() throws Exception {
        //Given
        Position position = new Position();
        //When
        Position nextPosition = orientation.forward(position);
        //Then
        Assertions.assertThat(nextPosition.getCoordX()).isEqualTo(2);
    }

    @Test
    public void should_turn_left_to_north_when_east() throws Exception {
        //When
        Orientation nextOrientation = orientation.turnLeft();
        //Then
        Assertions.assertThat(nextOrientation).isInstanceOf(OrientationNorth.class);
    }

    @Test
    public void should_turn_right_to_south_when_east() throws Exception {
        //When
        Orientation nextOrientation = orientation.turnRight();
        //Then
        Assertions.assertThat(nextOrientation).isInstanceOf(OrientationSouth.class);
    }
}
