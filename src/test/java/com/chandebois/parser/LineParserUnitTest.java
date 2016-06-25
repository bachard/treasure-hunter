package com.chandebois.parser;

import com.chandebois.domain.Mountain;
import com.chandebois.domain.Position;
import com.chandebois.domain.Treasure;
import com.chandebois.domain.TreasureMap;
import com.chandebois.io.model.HunterReaderModel;
import com.chandebois.orientation.OrientationEast;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created by nonok on 25/06/2016.
 */
public class LineParserUnitTest {

    @Test
    public void should_return_a_treasure_map_object_from_parsed_string() throws Exception {
        TreasureMap treasureMap = LineParser.parseTreasureMap("C 6 5");
        Assertions.assertThat(treasureMap).isNotNull();
        Assertions.assertThat(treasureMap.getWidth()).isEqualTo(6);
        Assertions.assertThat(treasureMap.getHeight()).isEqualTo(5);
    }

    @Test
    public void should_return_a_mountain_object_from_parsed_string() throws Exception {
        Mountain mountain = LineParser.parseMountain("M 5-3");
        Assertions.assertThat(mountain).isNotNull();
        Position expectedPosition = new Position(5, 3);
        Assertions.assertThat(mountain.getPosition()).isEqualTo(expectedPosition);
    }

    @Test
    public void should_return_a_treasure_object_from_parsed_string() throws Exception {
        Treasure treasure = LineParser.parseTreasure("T 4-2 1");
        Assertions.assertThat(treasure).isNotNull();
        Position expectedPosition = new Position(4, 2);
        Assertions.assertThat(treasure.getPosition()).isEqualTo(expectedPosition);
        Assertions.assertThat(treasure.getValue()).isEqualTo(1);
    }

    @Test
    public void should_return_a_hunter_reader_model_object_from_parsed_string() throws Exception {
        HunterReaderModel hunterReaderModel = LineParser.parseHunter("John 1-1 E AADADAGA");
        Assertions.assertThat(hunterReaderModel).isNotNull();
        Position expectedPosition = new Position(1, 1);
        Assertions.assertThat(hunterReaderModel.getPosition()).isEqualTo(expectedPosition);
        Assertions.assertThat(hunterReaderModel.getOrientation()).isInstanceOf(OrientationEast.class);
    }
}
