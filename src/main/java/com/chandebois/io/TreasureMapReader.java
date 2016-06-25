package com.chandebois.io;

import com.chandebois.domain.Mountain;
import com.chandebois.domain.Treasure;
import com.chandebois.domain.TreasureMap;
import com.chandebois.parser.LineParser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by nonok on 25/06/2016.
 */
@Service
@Qualifier("treasureMapReader")
public class TreasureMapReader implements Reader<TreasureMap> {

    @Override
    public TreasureMap read(File file) throws IOException {
        String currentLine;

        BufferedReader br = new BufferedReader(new FileReader(file));

        TreasureMap treasureMap = null;

        while ((currentLine = br.readLine()) != null) {
            if (currentLine.contains("C")) {
                treasureMap = LineParser.parseTreasureMap(currentLine);
            } else if (currentLine.contains("T")) {
                Treasure treasure = LineParser.parseTreasure(currentLine);
                treasureMap.addTreasure(treasure);
            } else if (currentLine.contains("M")) {
                Mountain mountain = LineParser.parseMountain(currentLine);
                treasureMap.addMountain(mountain);
            } else {
                //throw exception
            }
        }

        return treasureMap;
    }
}
