package com.truenorth.calculator.calculator.controllers;

import com.truenorth.calculator.calculator.dtos.MathRequestDTO;
import com.truenorth.calculator.calculator.dtos.RecordDTO;
import com.truenorth.calculator.calculator.models.OperationType;
import com.truenorth.calculator.calculator.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/math")
public class CalculatorController {
    @Autowired
    private CalculatorService service;

    @PostMapping("/addition")
    public RecordDTO add(@RequestBody MathRequestDTO mathRequestDTO) {
        return service.calculate(mathRequestDTO, OperationType.ADDITION);
    }

    @PostMapping("/subtraction")
    public RecordDTO subtract(@RequestBody MathRequestDTO mathRequestDTO) {
        return service.calculate(mathRequestDTO, OperationType.SUBTRACTION);
    }

    @PostMapping("/multiplication")
    public RecordDTO multiply(@RequestBody MathRequestDTO mathRequestDTO) {
        return service.calculate(mathRequestDTO, OperationType.MULTIPLICATION);
    }

    @PostMapping("/division")
    public RecordDTO divide(@RequestBody MathRequestDTO mathRequestDTO) {
        return service.calculate(mathRequestDTO, OperationType.DIVISION);
    }

    @PostMapping("/square-root")
    public RecordDTO squareRoot(@RequestBody MathRequestDTO mathRequestDTO) {
        return service.calculate(mathRequestDTO, OperationType.SQUARE_ROOT);
    }

    @PostMapping("/random-string")
    public RecordDTO randomString(@RequestBody MathRequestDTO mathRequestDTO) {
        return service.calculate(mathRequestDTO, OperationType.RANDOM_STRING);
    }
}
