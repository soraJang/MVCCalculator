package net.ion.calculator.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConnectCalcController {

	@RequestMapping({ "/jscalculator" })
	public String viewCalculatorJsForm() {
		return "calculatorForm";
	}

	@RequestMapping({ "/extjscalculator" })
	public String viewCalculatorExtJsForm() {
		return "TcalculatorForm";
	}

//	@RequestMapping({ "../MVCRestCalc/extjs/resources/css/ext-all.css" })
//	public String callCss() {
//		return "../MVCRestCalc/extjs/resources/css/ext-all.css";
//	}
//
//	@RequestMapping({ "../MVCRestCalc/extjs/ext-all-debug.js" })
//	public String callExtJs() {
//		return "../MVCRestCalc/extjs/ext-all-debug.js";
//	}
//
//	@RequestMapping({ "TcalculatorJS.js" })
//	public String callMyJs() {
//		return "TcalculatorJS.js";
//	}
}
