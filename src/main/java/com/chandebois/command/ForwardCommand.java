package com.chandebois.command;

import com.chandebois.domain.Hunter;

/**
 * Created by nonok on 25/06/2016.
 */
public class ForwardCommand implements Command {

    @Override
    public void move(Hunter hunter) {
        hunter.forward();
    }
}
