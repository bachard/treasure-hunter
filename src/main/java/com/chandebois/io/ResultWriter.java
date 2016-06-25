package com.chandebois.io;

import com.chandebois.domain.Hunter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by nonok on 25/06/2016.
 */
@Service
@Qualifier("resultWriter")
public class ResultWriter implements Writer<Hunter> {

    private PrintWriter printWriter;

    @Override
    public void openWriter(String fileName) throws FileNotFoundException, UnsupportedEncodingException {
        this.printWriter = new PrintWriter(fileName, "UTF-8");
    }

    @Override
    public void write(Hunter hunter) throws FileNotFoundException, UnsupportedEncodingException {
        this.printWriter.println(hunter.getName());
        this.printWriter.println(hunter.getPosition());
        this.printWriter.println(hunter.getOrientation());
        this.printWriter.println(hunter.getAmountOfTreasuresCollected());
        this.printWriter.println("-------------------------------------");
    }

    @Override
    public void close() {
        this.printWriter.close();
    }
}
