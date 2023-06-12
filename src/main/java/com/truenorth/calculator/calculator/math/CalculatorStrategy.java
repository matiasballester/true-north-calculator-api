package com.truenorth.calculator.calculator.math;

import com.truenorth.calculator.calculator.dtos.MathRequestDTO;
import com.truenorth.calculator.calculator.dtos.OperationResultDTO;

public interface CalculatorStrategy {
    OperationResultDTO calculate(MathRequestDTO mathRequestDTO);
    CalculatorStrategyName getStrategyName();

}
