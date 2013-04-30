package net.ion.calculator.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Calculator {

	Map<String, Operator> operators = new HashMap<String, Operator>();

	public Calculator() {
		operators.put(Addition.operator, new Addition());
		operators.put(Subtraction.operator, new Subtraction());
		operators.put(Multiplication.operator, new Multiplication());
		operators.put(Division.operator, new Division());
	}

	public BigDecimal operate(String operator, BigDecimal num1, BigDecimal num2) {
		return operators.get(operator).operate(num1, num2);
	}
}
