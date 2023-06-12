package com.truenorth.calculator.calculator.math;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class CalculatorStrategyFactory {
    private Map<CalculatorStrategyName, CalculatorStrategy> strategies;

    @Autowired
    public CalculatorStrategyFactory(Set<CalculatorStrategy> strategySet) {
        createStrategy(strategySet);
    }

    public CalculatorStrategy findStrategy(CalculatorStrategyName strategyName) {
        return strategies.get(strategyName);
    }
    private void createStrategy(Set<CalculatorStrategy> strategySet) {
        strategies = new HashMap<>();
        strategySet.forEach(
                strategy -> strategies.put(strategy.getStrategyName(), strategy));
    }
}
