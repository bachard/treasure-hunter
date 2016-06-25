package com.chandebois.io;

import com.chandebois.io.model.HunterReaderModel;
import com.chandebois.parser.LineParser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nonok on 25/06/2016.
 */
@Service
@Qualifier("hunterReader")
public class HunterReader implements Reader<List<HunterReaderModel>> {
    @Override
    public List<HunterReaderModel> read(File file) throws IOException {
        List<HunterReaderModel> hunterReaderModels = new ArrayList<>();

        String currentLine;
        BufferedReader br = new BufferedReader(new FileReader(file));

        while ((currentLine = br.readLine()) != null) {
            HunterReaderModel hunterReaderModel = LineParser.parseHunter(currentLine);
            hunterReaderModels.add(hunterReaderModel);
        }
        return hunterReaderModels;
    }
}
