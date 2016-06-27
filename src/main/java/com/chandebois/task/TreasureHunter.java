package com.chandebois.task;

import com.chandebois.command.Command;
import com.chandebois.domain.Hunter;

import java.util.Queue;

/**
 * Created by nonok on 25/06/2016.
 */
public class TreasureHunter {
    private Hunter hunter;
    private Queue<Command> commands;

    public Hunter getHunter() {
        return hunter;
    }

    public void setHunter(Hunter hunter) {
        this.hunter = hunter;
    }

    public Queue<Command> getCommands() {
        return commands;
    }

    public void setCommands(Queue<Command> commands) {
        this.commands = commands;
    }
}
