package net.ion.calculator.model;

import java.math.BigDecimal;

public class Addition implements Operator {

	public final static String operator = "+";

	public BigDecimal operate(BigDecimal num1, BigDecimal num2) {
		return num1.add(num2);
	}
}