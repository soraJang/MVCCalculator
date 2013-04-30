package net.ion.calculator.model;

import java.math.BigDecimal;

public class Subtraction implements Operator {

	public final static String operator = "-";

	public BigDecimal operate(BigDecimal num1, BigDecimal num2) {
		return num1.subtract(num2);
	}

}