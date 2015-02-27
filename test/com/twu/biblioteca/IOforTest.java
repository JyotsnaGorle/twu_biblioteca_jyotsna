package com.twu.biblioteca;

import java.io.IOException;

/**
 * Created by jyotsna on 27/02/15.
 */
public class IOforTest implements InputOutputManager{
    String input;
    String output;
    @Override
    public String getInput() throws IOException {
        return "1";
    }

    @Override
    public void writeOutput(String valueToWrite) {
        this.output=valueToWrite;
    }

    public String consoleOutput(){
        return output;
    }
}
