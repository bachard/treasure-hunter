package com.chandebois.io;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * Created by nonok on 25/06/2016.
 */
public interface Writer<T> {

    void openWriter(String fileName) throws FileNotFoundException, UnsupportedEncodingException;

    void write(T param) throws FileNotFoundException, UnsupportedEncodingException;

    void close();
}
