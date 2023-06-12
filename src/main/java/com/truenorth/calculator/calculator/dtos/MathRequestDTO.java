package com.truenorth.calculator.calculator.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MathRequestDTO {
    BigDecimal value1;
    BigDecimal value2;
}
