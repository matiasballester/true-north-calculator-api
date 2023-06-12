package com.truenorth.calculator.calculator.dtos;

import com.truenorth.calculator.calculator.entities.Operation;
public record RecordDTO (Long id, Operation operation, Double amount, Double userBalance){
}
