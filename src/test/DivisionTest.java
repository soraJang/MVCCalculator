package test;

import java.math.BigDecimal;

import junit.framework.TestCase;
import net.ion.calculator.model.Calculator;

public class DivisionTest extends TestCase {

	private Calculator calc = new Calculator();
	private final static String DIV_OPERATOR = "/";

	public void testDivideInt_Positive1() {
		BigDecimal num1 = new BigDecimal("1");
		BigDecimal num2 = new BigDecimal("2");

		BigDecimal result = calc.operate(DIV_OPERATOR, num1, num2);

		assertEquals("0.5", result.toPlainString());
	}

	public void testDivideInt_Negative1() {
		BigDecimal num1 = new BigDecimal("1");
		BigDecimal num2 = new BigDecimal("-2");

		BigDecimal result = calc.operate(DIV_OPERATOR, num1, num2);

		assertEquals("-0.5", result.toPlainString());
	}

	public void testDivideInt_PositiveNegative1() {
		BigDecimal num1 = new BigDecimal("-1");
		BigDecimal num2 = new BigDecimal("-2");

		BigDecimal result = calc.operate(DIV_OPERATOR, num1, num2);

		assertEquals("0.5", result.toPlainString());
	}

	public void testDivideInt_Positive2() {
		BigDecimal num1 = new BigDecimal("2");
		BigDecimal num2 = new BigDecimal("1");

		BigDecimal result = calc.operate(DIV_OPERATOR, num1, num2);

		assertEquals("2", result.toPlainString());
	}

	public void testDivideInt_Positive3() {
		BigDecimal num1 = new BigDecimal("0");
		BigDecimal num2 = new BigDecimal("2");

		BigDecimal result = calc.operate(DIV_OPERATOR, num1, num2);

		assertEquals("0", result.toPlainString());
	}

	public void testDivideInt_PositiveNegative2() {
		BigDecimal num1 = new BigDecimal("0");
		BigDecimal num2 = new BigDecimal("-1");

		BigDecimal result = calc.operate(DIV_OPERATOR, num1, num2);

		assertEquals("0", result.toPlainString());
	}

	public void testDivideInt_Positive4() {
		BigDecimal num1 = new BigDecimal("3");
		BigDecimal num2 = new BigDecimal("5");

		BigDecimal result = calc.operate(DIV_OPERATOR, num1, num2);

		assertEquals("0.6", result.toPlainString());
	}

	public void testDivideRealNum_Positive1() {
		BigDecimal num1 = new BigDecimal("0.9999999");
		BigDecimal num2 = new BigDecimal("0.9999999");

		BigDecimal result = calc.operate(DIV_OPERATOR, num1, num2);

		assertEquals("1", result.toPlainString());
	}

	public void testDivideRealNum_PositiveNegative1() {
		BigDecimal num1 = new BigDecimal("-0.9999999");
		BigDecimal num2 = new BigDecimal("0.9999999");

		BigDecimal result = calc.operate(DIV_OPERATOR, num1, num2);

		assertEquals("-1", result.toPlainString());
	}

	public void testDivideRealNum_PositiveNegative2() {
		BigDecimal num1 = new BigDecimal("0.9999999");
		BigDecimal num2 = new BigDecimal("-0.9999999");

		BigDecimal result = calc.operate(DIV_OPERATOR, num1, num2);

		assertEquals("-1", result.toPlainString());
	}

	public void testDivideRealNum_Negative1() {
		BigDecimal num1 = new BigDecimal("-0.9999999");
		BigDecimal num2 = new BigDecimal("-0.9999999");

		BigDecimal result = calc.operate(DIV_OPERATOR, num1, num2);

		assertEquals("1", result.toPlainString());
	}

	public void testDivideRealNum_Positive2() {
		BigDecimal num1 = new BigDecimal("0.1");
		BigDecimal num2 = new BigDecimal("2");

		BigDecimal result = calc.operate(DIV_OPERATOR, num1, num2);

		assertEquals("0.05", result.toPlainString());
	}

	public void testDivideRealNum_Positive3() {
		BigDecimal num1 = new BigDecimal("2");
		BigDecimal num2 = new BigDecimal("0.1");

		BigDecimal result = calc.operate(DIV_OPERATOR, num1, num2);

		assertEquals("20", result.toPlainString());
	}

	public void testDivideRealNum_Positive4() {
		BigDecimal num1 = new BigDecimal("0.05");
		BigDecimal num2 = new BigDecimal("0.8");

		BigDecimal result = calc.operate(DIV_OPERATOR, num1, num2);

		assertEquals("0.0625", result.toPlainString());
	}

	public void testDivideRealNum_PositiveNegative3() {
		BigDecimal num1 = new BigDecimal("0");
		BigDecimal num2 = new BigDecimal("-1.05");

		BigDecimal result = calc.operate(DIV_OPERATOR, num1, num2);

		assertEquals("0", result.toPlainString());
	}

	public void testDivideRealNum_Zero1() {
		try {
			BigDecimal num1 = new BigDecimal("0");
			BigDecimal num2 = new BigDecimal("0");

			calc.operate(DIV_OPERATOR, num1, num2);
		} catch (ArithmeticException e) {
			assertTrue(true);
		}
	}

	public void testDivideRealNum_Zero2() {
		try {
			BigDecimal num1 = new BigDecimal("-1");
			BigDecimal num2 = new BigDecimal("0");

			BigDecimal result = calc.operate(DIV_OPERATOR, num1, num2);

			assertEquals("", result.toPlainString());

		} catch (ArithmeticException e) {
			assertTrue(true);
		}
	}

	public void testDivideRealNum_EndlessNum() {
		try {
			BigDecimal num1 = new BigDecimal("1");
			BigDecimal num2 = new BigDecimal("3");

			calc.operate(DIV_OPERATOR, num1, num2);
		} catch (ArithmeticException e) {
			assertTrue(true);
		}
	}
}
