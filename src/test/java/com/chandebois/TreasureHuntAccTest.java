package com.chandebois;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ResourceUtils;

/**
 * Created by nonok on 25/06/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(TreasureHunt.class)
public class TreasureHuntAccTest {

    @Autowired
    private TreasureHunt treasureHunt;

    @Test
    public void name() throws Exception {
        treasureHunt.execute(ResourceUtils.getFile("classpath:treasure-map.txt").getAbsolutePath(), ResourceUtils.getFile("classpath:hunter.txt").getAbsolutePath(), "test.txt");
    }
}
