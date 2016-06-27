package com.chandebois;

import com.chandebois.builder.TreasureHunterBuilder;
import com.chandebois.io.ResultWriter;
import com.chandebois.task.TreasureHunter;
import com.chandebois.task.TreasureHunterTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by nonok on 22/06/2016.
 */
@Component
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.chandebois")
public class TreasureHunt {

    @Autowired
    private TreasureHunterBuilder treasureHunterBuilder;

    @Autowired
    private ResultWriter resultWriter;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(TreasureHunt.class, args);
    }

    public void execute(String treasureMapFilename, String treasureHunterFilename, String resultFileName) throws Exception {
        List<TreasureHunter> treasureHunters = treasureHunterBuilder.build(treasureMapFilename, treasureHunterFilename);

        executeTreasureHunterTask(treasureHunters);

        writeResultFile(resultFileName, treasureHunters);
    }

    private void executeTreasureHunterTask(List<TreasureHunter> treasureHunters) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(treasureHunters.size());
        CountDownLatch countDownLatch = new CountDownLatch(treasureHunters.size());
        for (TreasureHunter treasureHunter : treasureHunters) {
            TreasureHunterTask treasureHunterTask = new TreasureHunterTask(treasureHunter, countDownLatch);
            executor.scheduleAtFixedRate(treasureHunterTask, 0, 1, TimeUnit.SECONDS);
        }
        countDownLatch.await();
        executor.shutdown();
    }

    private void writeResultFile(String resultFileName, List<TreasureHunter> treasureHunters) throws FileNotFoundException, UnsupportedEncodingException {
        resultWriter.openWriter(resultFileName);
        for (TreasureHunter treasureHunter : treasureHunters) {
            resultWriter.write(treasureHunter.getHunter());
        }
        resultWriter.close();
    }
}
