package com.chandebois.orientation;

import com.chandebois.domain.Position;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nonok on 22/06/2016.
 */
public class OrientationSouthUnitTest {

    private Orientation orientation;

    @Before
    public void setUp() throws Exception {
        orientation = new OrientationSouth();
    }

    @Test
    public void should_forward_of_1_on_y_axis_in_south_direction() throws Exception {
        //Given
        Position position = new Position();
        //When
        Position nextPosition = orientation.forward(position);
        //Then
        Assertions.assertThat(nextPosition.getCoordY()).isEqualTo(2);
    }

    @Test
    public void should_turn_left_to_east_when_south() throws Exception {
        //When
        Orientation nextOrientation = orientation.turnLeft();
        //Then
        Assertions.assertThat(nextOrientation).isInstanceOf(OrientationEast.class);
    }

    @Test
    public void should_turn_right_to_west_when_south() throws Exception {
        //When
        Orientation nextOrientation = orientation.turnRight();
        //Then
        Assertions.assertThat(nextOrientation).isInstanceOf(OrientationWest.class);
    }
}
