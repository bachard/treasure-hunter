package com.chandebois;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

/**
 * Created by nonok on 22/06/2016.
 */
@Component
@EnableAutoConfiguration
public class TreasureHunt {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(TreasureHunt.class, args);
    }
}
