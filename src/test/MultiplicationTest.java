package test;

import java.math.BigDecimal;

import junit.framework.TestCase;
import net.ion.calculator.model.Calculator;

public class MultiplicationTest extends TestCase {

	private Calculator calc = new Calculator();
	private final static String MULTIPLE_OPERATOR = "*";

	public void testMultiplyInt_Positive1() {
		BigDecimal num1 = new BigDecimal("1");
		BigDecimal num2 = new BigDecimal("2");

		BigDecimal result = calc.operate(MULTIPLE_OPERATOR, num1, num2);

		assertEquals("2", result.toPlainString());
	}

	public void testMultiplyInt_PositiveNegative1() {
		BigDecimal num1 = new BigDecimal("1");
		BigDecimal num2 = new BigDecimal("-2");

		BigDecimal result = calc.operate(MULTIPLE_OPERATOR, num1, num2);

		assertEquals("-2", result.toPlainString());
	}

	public void testMultiplyInt_Negative1() {
		BigDecimal num1 = new BigDecimal("-1");
		BigDecimal num2 = new BigDecimal("-2");

		BigDecimal result = calc.operate(MULTIPLE_OPERATOR, num1, num2);

		assertEquals("2", result.toPlainString());
	}

	public void testMultiplyInt_PositiveNegative2() {
		BigDecimal num1 = new BigDecimal("-2");
		BigDecimal num2 = new BigDecimal("1");

		BigDecimal result = calc.operate(MULTIPLE_OPERATOR, num1, num2);

		assertEquals("-2", result.toPlainString());
	}

	public void testMultiplyInt_Zero1() {
		BigDecimal num1 = new BigDecimal("0");
		BigDecimal num2 = new BigDecimal("2");

		BigDecimal result = calc.operate(MULTIPLE_OPERATOR, num1, num2);

		assertEquals("0", result.toPlainString());
	}

	public void testMultiplyInt_Zero2() {
		BigDecimal num1 = new BigDecimal("0");
		BigDecimal num2 = new BigDecimal("-1");

		BigDecimal result = calc.operate(MULTIPLE_OPERATOR, num1, num2);

		assertEquals("0", result.toPlainString());
	}

	public void testMultiplyInt_Zero3() {
		BigDecimal num1 = new BigDecimal("0");
		BigDecimal num2 = new BigDecimal("0");

		BigDecimal result = calc.operate(MULTIPLE_OPERATOR, num1, num2);

		assertEquals("0", result.toPlainString());
	}

	public void testMultiplyInt_Zero4() {
		BigDecimal num1 = new BigDecimal("-1");
		BigDecimal num2 = new BigDecimal("0");

		BigDecimal result = calc.operate(MULTIPLE_OPERATOR, num1, num2);

		assertEquals("0", result.toPlainString());
	}

	public void testMultiplyInt_Positive2() {
		BigDecimal num1 = new BigDecimal("40");
		BigDecimal num2 = new BigDecimal("33");

		BigDecimal result = calc.operate(MULTIPLE_OPERATOR, num1, num2);

		assertEquals("1320", result.toPlainString());
	}

	public void testMultiplyRealNum_Positive1() {
		BigDecimal num1 = new BigDecimal("0.3333");
		BigDecimal num2 = new BigDecimal("0.3");

		BigDecimal result = calc.operate(MULTIPLE_OPERATOR, num1, num2);

		assertEquals("0.09999", result.toPlainString());
	}

	public void testMultiplyRealNum_PositiveNegative1() {
		BigDecimal num1 = new BigDecimal("-0.33");
		BigDecimal num2 = new BigDecimal("0.33");

		BigDecimal result = calc.operate(MULTIPLE_OPERATOR, num1, num2);

		assertEquals("-0.1089", result.toPlainString());
	}

	public void testMultiplyRealNum_Positive2() {
		BigDecimal num1 = new BigDecimal("2");
		BigDecimal num2 = new BigDecimal("0.1");

		BigDecimal result = calc.operate(MULTIPLE_OPERATOR, num1, num2);

		assertEquals("0.2", result.toPlainString());
	}

	public void testMultiplyRealNum_Positive3() {
		BigDecimal num1 = new BigDecimal("3333333333333333333333333333333");
		BigDecimal num2 = new BigDecimal("3");

		BigDecimal result = calc.operate(MULTIPLE_OPERATOR, num1, num2);

		assertEquals("9999999999999999999999999999999", result.toPlainString());
	}

	public void testMultiplyRealNum_Negative1() {
		BigDecimal num1 = new BigDecimal("-3333333333333333333333333333333");
		BigDecimal num2 = new BigDecimal("-3");

		BigDecimal result = calc.operate(MULTIPLE_OPERATOR, num1, num2);

		assertEquals("9999999999999999999999999999999", result.toPlainString());
	}

	public void testMultiplyRealNum_Positive4() {
		BigDecimal num1 = new BigDecimal("0.2");
		BigDecimal num2 = new BigDecimal("0.5");

		BigDecimal result = calc.operate(MULTIPLE_OPERATOR, num1, num2);

		assertEquals("0.10", result.toPlainString());
	}

	public void testMultiplyRealNum_Positive5() {
		BigDecimal num1 = new BigDecimal("5");
		BigDecimal num2 = new BigDecimal("0.2");

		BigDecimal result = calc.operate(MULTIPLE_OPERATOR, num1, num2);

		assertEquals("1.0", result.toPlainString());
	}

	public void testMultiplyRealNum_PositiveNegative2() {
		BigDecimal num1 = new BigDecimal("0.4");
		BigDecimal num2 = new BigDecimal("-2.5");

		BigDecimal result = calc.operate(MULTIPLE_OPERATOR, num1, num2);

		assertEquals("-1.00", result.toPlainString());
	}

	public void testMultiplyRealNum_Positive6() {
		BigDecimal num1 = new BigDecimal("4");
		BigDecimal num2 = new BigDecimal("0.25");

		BigDecimal result = calc.operate(MULTIPLE_OPERATOR, num1, num2);

		assertEquals("1.00", result.toPlainString());
	}

	public void testMultiplyRealNum_Zero1() {
		BigDecimal num1 = new BigDecimal("-1.5");
		BigDecimal num2 = new BigDecimal("0");

		BigDecimal result = calc.operate(MULTIPLE_OPERATOR, num1, num2);

		assertEquals("0.0", result.toPlainString());
	}

}
