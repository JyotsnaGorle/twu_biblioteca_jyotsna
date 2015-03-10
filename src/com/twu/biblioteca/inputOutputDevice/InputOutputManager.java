package com.twu.biblioteca.inputOutputDevice;

import java.io.IOException;

/**
 * Created by jyotsna on 27/02/15.
 */
public interface InputOutputManager {
    public String getInput()throws IOException;
    public void writeOutput(String valueToWrite);

}
