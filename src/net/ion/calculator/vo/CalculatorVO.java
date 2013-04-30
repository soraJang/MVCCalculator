package net.ion.calculator.vo;

import java.math.BigDecimal;

public class CalculatorVO {

	String operator;
	BigDecimal num1;
	BigDecimal num2;
	
	public CalculatorVO() {
		super();
	}

	public CalculatorVO(String operator, BigDecimal num1, BigDecimal num2) {
		super();
		this.operator = operator;
		this.num1 = num1;
		this.num2 = num2;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public BigDecimal getNum1() {
		return num1;
	}

	public void setNum1(BigDecimal num1) {
		this.num1 = num1;
	}

	public BigDecimal getNum2() {
		return num2;
	}

	public void setNum2(BigDecimal num2) {
		this.num2 = num2;
	}

	@Override
	public String toString() {
		return "CalculatorVO [operator=" + operator + ", num1=" + num1
				+ ", num2=" + num2 + "]";
	}


}
