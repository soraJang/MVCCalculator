package test;

import java.math.BigDecimal;

import junit.framework.TestCase;
import net.ion.calculator.model.Calculator;

public class SubtractionTest extends TestCase {

	private Calculator calc = new Calculator();
	private final static String MINUS_OPERATOR = "-";

	public void testMinusInt_Positive1() {
		BigDecimal num1 = new BigDecimal("1");
		BigDecimal num2 = new BigDecimal("2");

		BigDecimal result = calc.operate(MINUS_OPERATOR, num1, num2);

		assertEquals("-1", result.toPlainString());
	}

	public void testMinusInt_Positive2() {
		BigDecimal num1 = new BigDecimal("1");
		BigDecimal num2 = new BigDecimal("2");

		BigDecimal result = calc.operate(MINUS_OPERATOR, num1, num2);

		assertEquals("-1", result.toPlainString());
	}

	public void testMinusInt_Negative1() {
		BigDecimal num1 = new BigDecimal("-1");
		BigDecimal num2 = new BigDecimal("-2");

		BigDecimal result = calc.operate(MINUS_OPERATOR, num1, num2);

		assertEquals("1", result.toPlainString());
	}

	public void testMinusInt_PositiveNegative1() {
		BigDecimal num1 = new BigDecimal("1");
		BigDecimal num2 = new BigDecimal("-2");

		BigDecimal result = calc.operate(MINUS_OPERATOR, num1, num2);

		assertEquals("3", result.toPlainString());
	}

	public void testMinusInt_PositiveNegative2() {
		BigDecimal num1 = new BigDecimal("-1");
		BigDecimal num2 = new BigDecimal("2");

		BigDecimal result = calc.operate(MINUS_OPERATOR, num1, num2);

		assertEquals("-3", result.toPlainString());
	}

	public void testMinusInt_Positive3() {
		BigDecimal num1 = new BigDecimal("1");
		BigDecimal num2 = new BigDecimal("1");

		BigDecimal result = calc.operate(MINUS_OPERATOR, num1, num2);

		assertEquals("0", result.toPlainString());
	}

	public void testMinusRealNum_Positive1() {
		BigDecimal num1 = new BigDecimal("0.123");
		BigDecimal num2 = new BigDecimal("0.011");

		BigDecimal result = calc.operate(MINUS_OPERATOR, num1, num2);

		assertEquals("0.112", result.toPlainString());
	}

	public void testMinusRealNum_PositiveNegative1() {
		BigDecimal num1 = new BigDecimal("1.11111");
		BigDecimal num2 = new BigDecimal("-2.22222");

		BigDecimal result = calc.operate(MINUS_OPERATOR, num1, num2);

		assertEquals("3.33333", result.toPlainString());
	}

	public void testMinusRealNum_Negative() {
		BigDecimal num1 = new BigDecimal("-1.111");
		BigDecimal num2 = new BigDecimal("-2.111");

		BigDecimal result = calc.operate(MINUS_OPERATOR, num1, num2);

		assertEquals("1.000", result.toPlainString());
	}

	public void testMinusRealNum_Positive2() {
		BigDecimal num1 = new BigDecimal("1.1111111111");
		BigDecimal num2 = new BigDecimal("2.11111111111");

		BigDecimal result = calc.operate(MINUS_OPERATOR, num1, num2);

		assertEquals("-1.00000000001", result.toPlainString());
	}

	public void testMinusRealNum_PositiveNegative2() {
		BigDecimal num1 = new BigDecimal("1.1111111111");
		BigDecimal num2 = new BigDecimal("-2.11111111113");

		BigDecimal result = calc.operate(MINUS_OPERATOR, num1, num2);

		assertEquals("3.22222222223", result.toPlainString());
	}

	public void testMinusRealNum_Positive3() {
		BigDecimal num1 = new BigDecimal("0");
		BigDecimal num2 = new BigDecimal("2.44445");

		BigDecimal result = calc.operate(MINUS_OPERATOR, num1, num2);

		assertEquals("-2.44445", result.toPlainString());
	}

	public void testMinusRealNum_Zero() {
		BigDecimal num1 = new BigDecimal("0");
		BigDecimal num2 = new BigDecimal("0");

		BigDecimal result = calc.operate(MINUS_OPERATOR, num1, num2);

		assertEquals("0", result.toPlainString());
	}

	public void testMinusRealNum_Positive4() {
		BigDecimal num1 = new BigDecimal("1.34");
		BigDecimal num2 = new BigDecimal("0.32114");

		BigDecimal result = calc.operate(MINUS_OPERATOR, num1, num2);

		assertEquals("1.01886", result.toPlainString());
	}

	public void testMinusRealNum_Positive5() {
		BigDecimal num1 = new BigDecimal("1.1");
		BigDecimal num2 = new BigDecimal("1.1");

		BigDecimal result = calc.operate(MINUS_OPERATOR, num1, num2);

		assertEquals("0.0", result.toPlainString());
	}

	public void testMinusRealNum_PositiveNegative3() {
		BigDecimal num1 = new BigDecimal("0.9");
		BigDecimal num2 = new BigDecimal("-1.1");

		BigDecimal result = calc.operate(MINUS_OPERATOR, num1, num2);

		assertEquals("2.0", result.toPlainString());
	}

	public void testMinusRealNum_PositiveNegative4() {
		BigDecimal num1 = new BigDecimal("-1.55555");
		BigDecimal num2 = new BigDecimal("2.44445");

		BigDecimal result = calc.operate(MINUS_OPERATOR, num1, num2);

		assertEquals("-4.00000", result.toPlainString());
	}

	public void testMinusRealNum_Positive6() {
		BigDecimal num1 = new BigDecimal("11.01");
		BigDecimal num2 = new BigDecimal("0.01");

		BigDecimal result = calc.operate(MINUS_OPERATOR, num1, num2);

		assertEquals("11.00", result.toPlainString());
	}
}
