package com.chandebois.command;

/**
 * Created by nonok on 25/06/2016.
 */
public class CommandFactory {

    public static Command getCommand(char codeCommand) {
        Command command = null;
        switch (codeCommand) {
            case 'A':
                command = new ForwardCommand();
                break;
            case 'G':
                command = new TurnLeftCommand();
                break;
            case 'D':
                command = new TurnRightCommand();
                break;
            default:
                command = null;
        }
        return command;
    }
}
