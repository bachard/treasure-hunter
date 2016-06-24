package com.chandebois.domain;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nonok on 24/06/2016.
 */
public class TreasureMapUnitTest {

    private TreasureMap treasureMap;

    @Before
    public void setUp() throws Exception {
        treasureMap = new TreasureMap(6, 5);
    }

    @Test
    public void should_add_an_treasure_on_position_1_1_with_value_9() throws Exception {
        Position position = new Position(1, 1);
        Treasure treasure = new Treasure(position, 9);
        treasureMap.addTreasure(treasure);
        Assertions.assertThat(treasureMap.getTreasures()).isNotEmpty();
        Assertions.assertThat(treasureMap.getTreasures().get(0).getPosition().getCoordX()).isEqualTo(1);
        Assertions.assertThat(treasureMap.getTreasures().get(0).getPosition().getCoordY()).isEqualTo(1);
        Assertions.assertThat(treasureMap.getTreasures().get(0).getValue()).isEqualTo(9);
    }

    @Test
    public void should_add_an_mountain_on_position_1_1_with_value_9() throws Exception {
        Position position = new Position(1, 1);
        Mountain mountain = new Mountain(position);
        treasureMap.addMountain(mountain);
        Assertions.assertThat(treasureMap.getMountains()).isNotEmpty();
        Assertions.assertThat(treasureMap.getMountains().get(0).getPosition().getCoordX()).isEqualTo(1);
        Assertions.assertThat(treasureMap.getMountains().get(0).getPosition().getCoordY()).isEqualTo(1);
    }

    @Test
    public void should_return_true_when_inside_the_map() throws Exception {
        Position position = new Position(1, 1);
        boolean isInsideMap = treasureMap.isInsideMap(position);
        Assertions.assertThat(isInsideMap).isTrue();
    }

    @Test
    public void should_return_false_when_outside_the_map() throws Exception {
        Position position = new Position(7, 5);
        boolean isInsideMap = treasureMap.isInsideMap(position);
        Assertions.assertThat(isInsideMap).isFalse();
    }

}
