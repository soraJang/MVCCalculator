package net.ion.calculator.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Division implements Operator {

	public final static String operator = "/";

	public BigDecimal operate(BigDecimal num1, BigDecimal num2) {

		int size = 0;
		try {
			size = num1.divide(num2).scale();
		} catch (ArithmeticException ae) {
			size = 14;
		}
		return num1.divide(num2, size, RoundingMode.HALF_UP);
	}

}