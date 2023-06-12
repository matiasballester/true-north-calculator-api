package com.truenorth.calculator.calculator.math;

import com.truenorth.calculator.calculator.dtos.MathRequestDTO;
import com.truenorth.calculator.calculator.dtos.OperationResultDTO;
import org.springframework.stereotype.Component;

@Component
public class DivideStrategy implements CalculatorStrategy {
    @Override
    public OperationResultDTO calculate(MathRequestDTO mathRequestDTO) {
        return OperationResultDTO.builder().result(mathRequestDTO.getValue1().divide(mathRequestDTO.getValue2())).build();
    }

    @Override
    public CalculatorStrategyName getStrategyName() {
        return CalculatorStrategyName.DivideStrategy;
    }
}
