package net.ion.calculator.contorller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import net.ion.calculator.model.Calculator;
import net.ion.calculator.vo.CalculatorVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

	public String ChangeTypeOfOperator(String operator) {
		Map<String, String> map = new HashMap<String, String>();

		map.put("addition", "+");
		map.put("subtraction", "-");
		map.put("multiplication", "*");
		map.put("division", "/");

		return map.get(operator);
	}

	@RequestMapping(value = { "/calculator/{num1}/{num2}/{operator}" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	public ModelAndView connectOperator(@PathVariable("num1") BigDecimal num1,
			@PathVariable("num2") BigDecimal num2,
			@PathVariable("operator") String operator) {

		CalculatorVO calculatorVo = new CalculatorVO(
				ChangeTypeOfOperator(operator), num1, num2);

		return setModelAndViewData(calculatorVo);
	}

	public ModelAndView setModelAndViewData(
			@ModelAttribute CalculatorVO calculator) {
		ModelAndView mv = new ModelAndView();
		Calculator calc = new Calculator();

		mv.addObject("result", calc.operate(calculator.getOperator(),
				calculator.getNum1(), calculator.getNum2()));
		mv.setViewName("result");

		return mv;
	}
}