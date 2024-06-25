package com.esgi.csvcalculator;

import javax.management.AttributeNotFoundException;
import java.io.IOException;

public class Main {

    private final String csvPath;
    private final String operator;

    public Main(String[] args) {
        this.csvPath = args[0];
        this.operator = args[1];
    }

    public void run() throws IOException, AttributeNotFoundException {
        Calculator calculator = new Calculator();
        CsvIO csvIO = new CsvIO();

        System.out.println(calculator.calculateTotal(csvIO.openCsv(csvPath), Operator.getOperator(operator)));
    }
}
