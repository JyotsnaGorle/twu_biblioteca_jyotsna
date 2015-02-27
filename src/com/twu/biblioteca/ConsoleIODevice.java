package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jyotsna on 27/02/15.
 */
public class ConsoleIODevice implements InputOutputManager {
    @Override
    public String getInput() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String inputValue = read.readLine();
        return inputValue;
    }

    @Override
    public void writeOutput(String valueToWrite) {
        System.out.println(valueToWrite);
    }
}
