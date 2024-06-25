package com.esgi.csvcalculator;

import javax.management.AttributeNotFoundException;
import java.util.Arrays;

public enum Operator {
    PLUS("+"),
    MULTIPLY("*");

    private final String label;

    Operator(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static Operator getOperator(String label) throws AttributeNotFoundException {
        return Arrays.stream(Operator.values()).filter(o -> o.getLabel().equals(label)).findFirst().orElseThrow(AttributeNotFoundException::new);
    }
}
