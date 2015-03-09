package com.twu.biblioteca;

import java.io.IOException;
import java.util.List;

/**
 * Created by jyotsna on 27/02/15.
 */
public class IOforTest implements InputOutputManager{
    List<String> input;
    String output;
    int currentReadIndex;

    IOforTest(){
        this.output="";
        currentReadIndex =0;
    }

    public void setWithUserInputs(List<String> inputs) {
        this.input = inputs;
        this.output = "";
    }

    @Override
    public String getInput() throws IOException {
        return input.get(currentReadIndex++);
    }

        @Override
    public void writeOutput(String valueToWrite) {
        this.output+=valueToWrite;
    }

    public String consoleOutput(){
        return output;
    }

}
