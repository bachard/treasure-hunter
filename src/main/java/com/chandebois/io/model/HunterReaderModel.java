package com.chandebois.io.model;

import com.chandebois.command.Command;
import com.chandebois.domain.Position;
import com.chandebois.orientation.Orientation;

import java.util.Queue;

/**
 * Created by nonok on 25/06/2016.
 */
public class HunterReaderModel {
    private String name;
    private Position position;
    private Orientation orientation;
    private Queue<Command> commands;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Queue<Command> getCommands() {
        return commands;
    }

    public void setCommands(Queue<Command> commands) {
        this.commands = commands;
    }
}
