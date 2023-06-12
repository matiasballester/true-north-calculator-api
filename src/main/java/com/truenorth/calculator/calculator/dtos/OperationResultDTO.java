package com.truenorth.calculator.calculator.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class OperationResultDTO {
    private BigDecimal result;
    private String randomString;
}
