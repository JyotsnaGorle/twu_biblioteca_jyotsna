package com.twu.biblioteca;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jyotsna on 27/02/15.
 */
public class IOforTest implements InputOutputManager{
    List<String> input;
    String output;
    int i;
    IOforTest(){
        this.output="";
        i=0;
    }

    IOforTest(List<String> inputValues){
        this.input= inputValues;
        this.output ="";
    }

    public void withUserInputs(String... inputs) {
        this.input = Arrays.asList(inputs);
        this.output="";
    }

    @Override
    public String getInput() throws IOException {
        if(input.size()>1)
         return input.get(i++);
        return input.get(i);
    }

        @Override
    public void writeOutput(String valueToWrite) {
        this.output+=valueToWrite;
    }

    public String consoleOutput(){
        return output;
    }

}
