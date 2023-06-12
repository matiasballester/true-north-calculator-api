package com.truenorth.calculator.calculator.math;

import com.truenorth.calculator.calculator.dtos.MathRequestDTO;
import com.truenorth.calculator.calculator.dtos.OperationResultDTO;

import java.math.MathContext;

public class SquareRootStrategy implements CalculatorStrategy {

    @Override
    public OperationResultDTO calculate(MathRequestDTO mathRequestDTO) {
        return OperationResultDTO.builder().result(mathRequestDTO.getValue1().sqrt(new MathContext(10))).build();
    }

    @Override
    public CalculatorStrategyName getStrategyName() {
        return CalculatorStrategyName.SquareRootStrategy;
    }
}
