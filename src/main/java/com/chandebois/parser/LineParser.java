package com.chandebois.parser;

import com.chandebois.command.Command;
import com.chandebois.command.CommandFactory;
import com.chandebois.domain.*;
import com.chandebois.orientation.Orientation;
import com.chandebois.orientation.OrientationFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nonok on 25/06/2016.
 */
public class LineParser {

    public static TreasureMap parseTreasureMap(final String line) {
        int width = Character.getNumericValue(line.charAt(2));
        int height = Character.getNumericValue(line.charAt(4));
        return new TreasureMap(width, height);
    }

    public static Mountain parseMountain(final String line) {
        final int width = Character.getNumericValue(line.charAt(2));
        final int height = Character.getNumericValue(line.charAt(4));
        final Position position = new Position(width, height);
        return new Mountain(position);
    }

    public static Treasure parseTreasure(final String line) {
        final int width = Character.getNumericValue(line.charAt(2));
        final int height = Character.getNumericValue(line.charAt(4));
        final int value = Character.getNumericValue(line.charAt(6));
        final Position position = new Position(width, height);
        return new Treasure(position, value);
    }

    public static Hunter parseHunter(final String line, final TreasureMap treasureMap) {
        String[] tabLines = line.split(" ");
        final String hunterName = tabLines[0];

        final int coordX = Integer.valueOf(tabLines[1].split("-")[0]);
        final int coordY = Integer.valueOf(tabLines[1].split("-")[1]);
        final Position position = new Position(coordX, coordY);

        final Orientation orientation = OrientationFactory.getOrientation(tabLines[2].charAt(0));

        Hunter hunter = new Hunter
                .HunterBuilder(position, orientation, treasureMap)
                .name(hunterName)
                .build();
        return hunter;
    }

    public static List<Command> parseCommands(final String line) {
        List<Command> commands = new ArrayList<>();
        String[] tabLines = line.split(" ");
        tabLines[3].chars()
                .mapToObj(c -> (char) c)
                .forEach(codeCommand -> {
                    commands.add(CommandFactory.getCommand(codeCommand));
                });
        return commands;
    }
}
