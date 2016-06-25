package com.chandebois.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by nonok on 25/06/2016.
 */
public interface Reader<T> {
    T read(File file) throws IOException;
}
