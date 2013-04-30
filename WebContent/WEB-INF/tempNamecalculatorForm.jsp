<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>

<!-- 계산기 그냥 틀만잡고 만든거! -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Calculator</title>
<script type="text/javascript">
var xmlHttp; 
var num1;
var num2;
var operator;

function createXMLHttpRequest() {
		if (window.ActiveXObject) {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) {
			xmlHttp = new XMLHttpRequest();
		}
	}

	function startRequest() {
		num1 = document.getElementById("num1").value;
		num2 = document.getElementById("num2").value;
		operator = getOperator();

		if (num1 == null || num2 == null || operator == null) {
			return;
		}

		else {
			url = "http://" + window.location.host
					+ "${pageContext.request.contextPath}" + "/calculator/"
					+ num1 + "/" + num2 + "/" + operator;
			createXMLHttpRequest();

			xmlHttp.open("POST", url, true);
			xmlHttp.onreadystatechange = handleStateChange;
			xmlHttp.send(null);
		}
	}

	function handleStateChange() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				document.getElementById("result").value = xmlHttp.responseText;
			}
		}
	}

	function getOperator() {
		var operator_length = document.operatorData.operator.length;
		for (i = 0; i < operator_length; i++) {
			if (document.operatorData.operator[i].checked == true) {
				operator = document.operatorData.operator[i].value;
			}
		}
		return operator;
	}
	
	function check(num){
		var pattern=/^[0-9]+$/;
		if (!pattern.test(num)){
			document.getElementById("insertButton").disabled=true;
		}
		else {
			document.getElementById("insertButton").disabled=false;
		}			
	}
</script>
</head>

<body>
	<form name="operatorData" method="POST">
		<table border="1">
			<tr>
				<td><input type="text" value="num1: " disabled="disabled"
					size="11" >
				</td>
				<td width="100"><input type="text" name="num1" size="30" id="num1" onblur="check(num1.value)"/></td>
				<td colspan="4">
					<input type="radio" name="operator" value="addition" />+ 
					<input type="radio" name="operator" value="subtraction" />- 
					<input type="radio" name="operator" value="division" />/ 
					<input type="radio" name="operator" value="multiplication" />*</td>
			</tr>
			<tr>
				<td><input type="text" id="showOperator" value="num2: " disabled="disabled"
					size="11">
				</td>
				<td width="100"><input type="text" name="num2" size="30" id="num2" onblur="check(num2.value)"/></td>
				<td colspan="4"><input id="insertButton" type="button" value=" = " size="5" onclick="startRequest()"/></td>
			</tr>
			<tr>
				<td><input type="text" value="Answer: " disabled="disabled"
					size="11"></td>
				<td width="100" colspan="4"><input type="text" name="result"
					size="40" disabled="disabled" id="result">
				</td>
				<td><input type="submit" value=" C " size="5"/></td>
			</tr>
		</table>
	</form>
</body>
</html>