package com.chandebois;

import com.chandebois.builder.TreasureHunterBuilder;
import com.chandebois.io.ResultWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.*;

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

    public void execute() throws FileNotFoundException, InterruptedException, ExecutionException, UnsupportedEncodingException {
        List<TreasureHunter> treasureHunters = treasureHunterBuilder.build(ResourceUtils.getFile("classpath:treasure-map.txt").getAbsolutePath(), ResourceUtils.getFile("classpath:hunter.txt").getAbsolutePath());

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(treasureHunters.size());

        CountDownLatch countDownLatch = new CountDownLatch(treasureHunters.size());
        for (TreasureHunter treasureHunter : treasureHunters) {
            TreasureHunterTask treasureHunterTask = new TreasureHunterTask(treasureHunter, countDownLatch);
            executor.scheduleAtFixedRate(treasureHunterTask, 0, 1, TimeUnit.SECONDS);
        }

        countDownLatch.await();
        executor.shutdown();

        //write file
        resultWriter.openWriter("test.txt");
        for (TreasureHunter treasureHunter : treasureHunters) {
            resultWriter.write(treasureHunter.getHunter());
        }
        resultWriter.close();
    }
}
