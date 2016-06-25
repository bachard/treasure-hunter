package com.chandebois.parser;

import com.chandebois.command.Command;
import com.chandebois.command.ForwardCommand;
import com.chandebois.domain.*;
import com.chandebois.orientation.OrientationEast;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

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
    public void should_return_a_hunter_object_from_parsed_string() throws Exception {
        Hunter hunter = LineParser.parseHunter("John 1-1 E AADADAGA", new TreasureMap(6, 5));
        Assertions.assertThat(hunter).isNotNull();
        Position expectedPosition = new Position(1, 1);
        Assertions.assertThat(hunter.getPosition()).isEqualTo(expectedPosition);
        Assertions.assertThat(hunter.getOrientation()).isInstanceOf(OrientationEast.class);
    }

    @Test
    public void should_return_a_list_of_commands_from_parsed_string() throws Exception {
        List<Command> commands = LineParser.parseCommands("John 1-1 E AADADAGA");
        Assertions.assertThat(commands).isNotEmpty();
        Assertions.assertThat(commands.get(0)).isInstanceOf(ForwardCommand.class);
    }
}
