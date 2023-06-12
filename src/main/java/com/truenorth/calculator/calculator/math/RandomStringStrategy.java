package com.truenorth.calculator.calculator.math;

import com.truenorth.calculator.calculator.dtos.MathRequestDTO;
import com.truenorth.calculator.calculator.dtos.OperationResultDTO;

public class RandomStringStrategy implements CalculatorStrategy {

    @Override
    public OperationResultDTO calculate(MathRequestDTO mathRequestDTO) {
        return null;
    }

    @Override
    public CalculatorStrategyName getStrategyName() {
        return CalculatorStrategyName.RandomStringStrategy;
    }
}
