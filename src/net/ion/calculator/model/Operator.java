package net.ion.calculator.model;

import java.math.BigDecimal;

public interface Operator {
	BigDecimal operate(BigDecimal num1, BigDecimal num2);
}
