package test;

import java.math.BigDecimal;

import junit.framework.TestCase;
import net.ion.calculator.model.Calculator;

public class AdditionTest extends TestCase {

	private Calculator calc = new Calculator();
	private final static String ADD_OPERATOR = "+";

	public void testAddInteger_Positive() {
		BigDecimal num1 = new BigDecimal("1");
		BigDecimal num2 = new BigDecimal("2");

		BigDecimal result = calc.operate(ADD_OPERATOR, num1, num2);

		assertEquals("3", result.toPlainString());
	}

	public void testAddInteger_Negative() {
		BigDecimal num1 = new BigDecimal("-1");
		BigDecimal num2 = new BigDecimal("-2");

		BigDecimal result = calc.operate(ADD_OPERATOR, num1, num2);

		assertEquals("-3", result.toPlainString());
	}
	
	public void testAddInteger_PositiveNegative1(){
		BigDecimal num1 = new BigDecimal("1");
		BigDecimal num2 = new BigDecimal("-2");
		
		BigDecimal result = calc.operate(ADD_OPERATOR, num1, num2);

		assertEquals("-1",result.toPlainString());
	}

	public void testAddInteger_PositiveNegative2(){
		BigDecimal num1 = new BigDecimal("1");
		BigDecimal num2 = new BigDecimal("-1");
		
		BigDecimal result = calc.operate(ADD_OPERATOR, num1, num2);

		assertEquals("0",result.toPlainString());
	}

	public void testAddRealNum_Positive1() {
		BigDecimal num1 = new BigDecimal("0.9999999");
		BigDecimal num2 = new BigDecimal("0.9999999");

		BigDecimal result = calc.operate(ADD_OPERATOR, num1, num2);
		
		assertEquals("1.9999998", result.toPlainString());
	}
	
	public void testAddRealNum_PositiveNegative1() {
		BigDecimal num1 = new BigDecimal("1.11111");
		BigDecimal num2 = new BigDecimal("-2.22222");

		BigDecimal result = calc.operate(ADD_OPERATOR, num1, num2);
		
		assertEquals("-1.11111", result.toPlainString());
	}

	public void testAddRealNum_Negative() {
		BigDecimal num1 = new BigDecimal("-1.1111111111");
		BigDecimal num2 = new BigDecimal("-2.11111111111");

		BigDecimal result = calc.operate(ADD_OPERATOR, num1, num2);
		assertEquals("-3.22222222221", result.toPlainString());
	}

	public void testAddRealNum_Positive2() {
		BigDecimal num1 = new BigDecimal("1.1111111111");
		BigDecimal num2 = new BigDecimal("2.11111111111");

		BigDecimal result = calc.operate(ADD_OPERATOR, num1, num2);
		assertEquals("3.22222222221", result.toPlainString());
	}

	public void testAddRealNum_PositiveNegative2() {
		BigDecimal num1 = new BigDecimal("1.1111111111");
		BigDecimal num2 = new BigDecimal("-2.11111111112");

		BigDecimal result = calc.operate(ADD_OPERATOR, num1, num2);
		assertEquals("-1.00000000002", result.toPlainString());
	}

	public void testAddRealNum_Positive() {
		BigDecimal num1 = new BigDecimal("0");
		BigDecimal num2 = new BigDecimal("2.44445");

		BigDecimal result = calc.operate(ADD_OPERATOR, num1, num2);
		assertEquals("2.44445", result.toPlainString());
	}

	public void testAddRealNum_Zero() {
		BigDecimal num1 = new BigDecimal("0");
		BigDecimal num2 = new BigDecimal("0");

		BigDecimal result = calc.operate(ADD_OPERATOR, num1, num2);
		assertEquals("0", result.toPlainString());
	}

	public void testAddRealNum_Positive3() {
		BigDecimal num1 = new BigDecimal("1.34");
		BigDecimal num2 = new BigDecimal("0.32114");

		BigDecimal result = calc.operate(ADD_OPERATOR, num1, num2);
		assertEquals("1.66114", result.toPlainString());
	}

	public void testAddRealNum_Positive4() {
		BigDecimal num1 = new BigDecimal(
				"1.111111111111111111111111111111111111111111111111111111111111");
		BigDecimal num2 = new BigDecimal(
				"2.2222222222222222222222222222222222222222222222222222222222221");

		BigDecimal result = calc.operate(ADD_OPERATOR, num1, num2);
		assertEquals(
				"3.3333333333333333333333333333333333333333333333333333333333331",
				result.toPlainString());
	}

	public void testAddRealNum_PositiveNegative3() {
		BigDecimal num1 = new BigDecimal("-1.1");
		BigDecimal num2 = new BigDecimal("1.1");

		BigDecimal result = calc.operate(ADD_OPERATOR, num1, num2);
		assertEquals("0.0", result.toPlainString());
	}

	public void testAddRealNum_Positive5() {
		BigDecimal num1 = new BigDecimal("0.9");
		BigDecimal num2 = new BigDecimal("1.1");

		BigDecimal result = calc.operate(ADD_OPERATOR, num1, num2);
		assertEquals("2.0", result.toPlainString());
	}

	public void testAddRealNum_Positive6() {
		BigDecimal num1 = new BigDecimal("1.55555");
		BigDecimal num2 = new BigDecimal("2.44445");

		BigDecimal result = calc.operate(ADD_OPERATOR, num1, num2);
		assertEquals("4.00000", result.toPlainString());
	}

	public void testAddRealNum_PositiveNegative4() {
		BigDecimal num1 = new BigDecimal("11.01");
		BigDecimal num2 = new BigDecimal("-0.01");

		BigDecimal result = calc.operate(ADD_OPERATOR, num1, num2);
		assertEquals("11.00", result.toPlainString());
	}
}
