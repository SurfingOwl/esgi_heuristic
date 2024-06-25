package com.esgi;

import com.esgi.csvcalculator.Main;

import javax.management.AttributeNotFoundException;
import java.io.IOException;

public class App {

    // Needs 2 argument in CLI -> csv path & operator "+" or "*"
    public static void main(String[] args) throws IOException, AttributeNotFoundException {
        new Main(args).run();
    }
}
