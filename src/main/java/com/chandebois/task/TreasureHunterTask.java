package com.chandebois.task;

import com.chandebois.command.Command;

import java.util.concurrent.CountDownLatch;

/**
 * Created by nonok on 25/06/2016.
 */
public class TreasureHunterTask implements Runnable {

    private TreasureHunter treasureHunter;
    private final CountDownLatch countDownLatch;
    private boolean isExecuted;

    public TreasureHunterTask(TreasureHunter treasureHunter, CountDownLatch countDownLatch) {
        this.treasureHunter = treasureHunter;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        if (!treasureHunter.getCommands().isEmpty()) {
            Command command = this.treasureHunter.getCommands().poll();
            command.move(treasureHunter.getHunter());
            System.out.println("moving hunter " + treasureHunter.getHunter().getName() + " " + Thread.currentThread());
        } else {
            if (!isExecuted) {
                countDownLatch.countDown();
                isExecuted = true;
            }
        }
    }
}
