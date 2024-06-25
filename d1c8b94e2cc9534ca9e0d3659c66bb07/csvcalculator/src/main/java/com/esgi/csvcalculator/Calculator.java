package com.esgi.csvcalculator;

import java.util.LinkedList;
import java.util.List;

public class Calculator {

    public String calculateTotal(List<LinkedList<String>> csv, Operator operator) {
        int total = Integer.parseInt(csv.get(0).removeFirst());


        for (List<String> lines : csv) {
            for (String e : lines) {
                int element = Integer.parseInt(e);
                switch (operator) {
                    case PLUS -> total += element;
                    case MULTIPLY -> total *= element;
                }
            }
        }

        return Integer.toString(total);
    }
}
