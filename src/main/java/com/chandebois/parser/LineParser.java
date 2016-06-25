package com.chandebois.parser;

import com.chandebois.command.Command;
import com.chandebois.command.CommandFactory;
import com.chandebois.domain.Mountain;
import com.chandebois.domain.Position;
import com.chandebois.domain.Treasure;
import com.chandebois.domain.TreasureMap;
import com.chandebois.io.model.HunterReaderModel;
import com.chandebois.orientation.Orientation;
import com.chandebois.orientation.OrientationFactory;

import java.util.LinkedList;
import java.util.Queue;

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

    public static HunterReaderModel parseHunter(final String line) {
        String[] tabLines = line.split(" ");
        final String hunterName = tabLines[0];

        final int coordX = Integer.valueOf(tabLines[1].split("-")[0]);
        final int coordY = Integer.valueOf(tabLines[1].split("-")[1]);
        final Position position = new Position(coordX, coordY);

        final Orientation orientation = OrientationFactory.getOrientation(tabLines[2].charAt(0));

        Queue<Command> commands = new LinkedList<>();
        tabLines[3].chars()
                .mapToObj(c -> (char) c)
                .forEach(codeCommand -> {
                    commands.add(CommandFactory.getCommand(codeCommand));
                });

        HunterReaderModel hunterReaderModel = new HunterReaderModel();
        hunterReaderModel.setName(hunterName);
        hunterReaderModel.setPosition(position);
        hunterReaderModel.setOrientation(orientation);
        hunterReaderModel.setCommands(commands);

        return hunterReaderModel;
    }
}
