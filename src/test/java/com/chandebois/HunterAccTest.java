package com.chandebois;

import com.chandebois.domain.*;
import com.chandebois.orientation.Orientation;
import com.chandebois.orientation.OrientationEast;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nonok on 24/06/2016.
 */
public class HunterAccTest {

    private TreasureMap treasureMap;
    private Hunter hunter;

    @Before
    public void setUp() throws Exception {
        Mountain mountain = new Mountain(new Position(3,1));
        Treasure treasure = new Treasure(new Position(3, 2), 2);
        treasureMap = new TreasureMap(6, 5);
        treasureMap.addMountain(mountain);
        treasureMap.addTreasure(treasure);

        Position hunterPosition = new Position(1,1);
        Orientation hunterOrientation = new OrientationEast();
        hunter = new Hunter
                    .HunterBuilder(hunterPosition, hunterOrientation, treasureMap)
                    .build();
    }

    @Test
    public void should_stop_when_a_mountain_is_present() throws Exception {
        hunter.forward();
        hunter.forward();
        Assertions.assertThat(hunter.getPosition().getCoordX()).isEqualTo(2);
    }

    @Test
    public void should_forward_and_collect_a_treasure() throws Exception {
        hunter.forward();
        hunter.turnRight();
        hunter.forward();
        hunter.turnLeft();
        hunter.forward();
        Assertions.assertThat(hunter.getPosition().getCoordX()).isEqualTo(3);
        Assertions.assertThat(hunter.getPosition().getCoordY()).isEqualTo(2);
        Assertions.assertThat(hunter.getAmountOfTreasuresCollected()).isEqualTo(1);
        Assertions.assertThat(treasureMap.getTreasures().size()).isEqualTo(0);
    }
}
