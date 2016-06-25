package com.chandebois.builder;

import com.chandebois.TreasureHunter;
import com.chandebois.domain.Hunter;
import com.chandebois.domain.TreasureMap;
import com.chandebois.io.HunterReader;
import com.chandebois.io.TreasureMapReader;
import com.chandebois.io.model.HunterReaderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nonok on 25/06/2016.
 */
@Service
@Qualifier("treasureHunterBuilder")
public class TreasureHunterBuilder {

    @Autowired
    @Qualifier("hunterReader")
    private HunterReader hunterReader;
    @Autowired
    @Qualifier("treasureMapReader")
    private TreasureMapReader treasureMapReader;

    public List<TreasureHunter> build(String treasureMapFile, String treasureHunterFile) {

        List<TreasureHunter> treasureHunters = new ArrayList<>();

        try {
            TreasureMap treasureMap = treasureMapReader.read(new File(treasureMapFile));
            List<HunterReaderModel> hunterReaderModels = hunterReader.read(new File(treasureHunterFile));
            hunterReaderModels.forEach(hrm -> {
                TreasureHunter treasureHunter = new TreasureHunter();
                Hunter hunter = new Hunter.HunterBuilder(hrm.getPosition(), hrm.getOrientation(), treasureMap)
                        .name(hrm.getName())
                        .build();
                treasureHunter.setHunter(hunter);
                treasureHunter.setCommands(hrm.getCommands());
                treasureHunters.add(treasureHunter);
            });
        } catch (IOException e) {
            //LOG exception
        }
        return treasureHunters;
    }
}
