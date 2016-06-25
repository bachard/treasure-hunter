package com.chandebois.domain;

import com.chandebois.orientation.Orientation;
import com.chandebois.orientation.OrientationEast;
import com.chandebois.orientation.OrientationNorth;
import com.chandebois.orientation.OrientationWest;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nonok on 24/06/2016.
 */
public class HunterUnitTest {

    private Hunter hunter;
    private Position position;
    private Orientation orientation;
    private TreasureMap treasureMap;

    @Before
    public void setUp() throws Exception {
        position = new Position();
        orientation = new OrientationNorth();
        treasureMap = new TreasureMap(6, 5);
        hunter = new Hunter
                    .HunterBuilder(position, orientation, treasureMap)
                    .build();
    }

    @Test
    public void should_hunter_forward_of_1_on_y_axis() throws Exception {
        hunter.forward();
        Assertions.assertThat(hunter.getPosition().getCoordY()).isEqualTo(1);
    }

    @Test
    public void should_hunter_turn_left_to_west_when_north() throws Exception {
        hunter.turnLeft();
        Assertions.assertThat(hunter.getOrientation()).isInstanceOf(OrientationWest.class);
    }

    @Test
    public void should_hunter_turn_right_to_east_when_north() throws Exception {
        hunter.turnRight();
        Assertions.assertThat(hunter.getOrientation()).isInstanceOf(OrientationEast.class);
    }

    @Test
    public void should_hunter_return_1_when_collected_1_treasure() throws Exception {
        hunter.addTreasure(new Treasure());
        Assertions.assertThat(hunter.getTreasures().size()).isEqualTo(1);
    }


}
