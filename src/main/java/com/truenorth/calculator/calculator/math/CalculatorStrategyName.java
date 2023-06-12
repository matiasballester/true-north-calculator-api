package com.truenorth.calculator.calculator.math;

import com.truenorth.calculator.calculator.models.OperationType;

import java.util.HashMap;
import java.util.Map;

public enum CalculatorStrategyName {
    AddStrategy(OperationType.ADDITION.name()),
    SubtractStrategy(OperationType.SUBTRACTION.name()),
    DivideStrategy(OperationType.DIVISION.name()),
    MultiplyStrategy(OperationType.MULTIPLICATION.name()),
    SquareRootStrategy(OperationType.SQUARE_ROOT.name()),
    RandomStringStrategy(OperationType.RANDOM_STRING.name());

    private static final Map<String, CalculatorStrategyName> BY_LABEL = new HashMap<>();

    static {
        for (CalculatorStrategyName strategyName: values()) {
            BY_LABEL.put(strategyName.label, strategyName);
        }
    }

    private String label;
    CalculatorStrategyName(String label) {
        this.label = label;
    }

    public static CalculatorStrategyName valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }
}
