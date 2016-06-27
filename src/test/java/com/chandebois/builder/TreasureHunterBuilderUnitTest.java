package com.chandebois.builder;

import com.chandebois.TreasureHunt;
import com.chandebois.task.TreasureHunter;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ResourceUtils;

import java.util.List;

/**
 * Created by nonok on 25/06/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(TreasureHunt.class)
public class TreasureHunterBuilderUnitTest {

    @Autowired
    @Qualifier("treasureHunterBuilder")
    private TreasureHunterBuilder treasureHunterBuilder;

    @Test
    public void name() throws Exception {
        List<TreasureHunter> treasureHunters = treasureHunterBuilder.build(ResourceUtils.getFile("classpath:treasure-map.txt").getAbsolutePath(), ResourceUtils.getFile("classpath:hunter.txt").getAbsolutePath());
        Assertions.assertThat(treasureHunters).isNotEmpty();
        Assertions.assertThat(treasureHunters.get(0).getHunter()).isNotNull();
        Assertions.assertThat(treasureHunters.get(0).getCommands()).isNotEmpty();
    }
}
