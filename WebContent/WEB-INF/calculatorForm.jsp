<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Calculator</title>

<style>
.btn {
	font: arial;
	width: 30px;
	font-size: 13px;
}
</style>

<!-- <script src="biginteger.js"></script>
<script src="decimal.js"></script> -->
<script type="text/javascript">
	var xmlHttp;
	var firstNum = "";
	var secondNum = "";
	var tempSecondNum = "";
	var operator = "";

	var topScreenList = "";
	var tempTopScreenList = "";

	var checkFirstIsNum = false;
	var checkStartfromEquals = false;
	var checkEquals = false;
	var checkPoint = 1;
	var checkNumStyle = false;

	var num = "";
	var tempNum = "";
	var result = "";

	var equalsCount = 0;

	var map = {};
	map['+'] = 'addition';
	map['-'] = 'subtraction';
	map['*'] = 'multiplication';
	map['/'] = 'division';

	function createXMLHttpRequest() {
		if (window.ActiveXObject) {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) {
			xmlHttp = new XMLHttpRequest();
		}
	}

	function startRequest() {
		url = "http://" + window.location.host
				+ "${pageContext.request.contextPath}" + "/calculator/"
				+ firstNum + "/" + secondNum + "/" + map[operator];

		createXMLHttpRequest();

		xmlHttp.open("POST", url, true);
		xmlHttp.onreadystatechange = handleStateChange;
		xmlHttp.send(null);
	}

	function handleStateChange() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				result = xmlHttp.responseText;
				changeRowScreen(result);
				firstNum = result;
			} else {
				changeRowScreen("I can't calculate.");
			}
		}
	}

	function changeNumStyle() {
		if (tempNum === "") {
			tempNum = result;
			checkFirstNum = true;
		}
		tempNum = tempNum * -1;
		changeRowScreen(tempNum);
		checkNumStyle = true;
	}

	function putNum(insertNum) {
		if (tempNum.length <= 14) {
			if (insertNum === "." && checkPoint === 1) {
				insertNum = ".";
				checkPoint++;
			} else if (insertNum === "." && checkPoint > 1) {
				insertNum = "";
			}
		} else {
			alert("you can't insert anymore");
			insertNum = "";
		}
		tempNum += insertNum;
		changeRowScreen(tempNum);
		checkFirstIsNum = true;
	}

	function setSecondNum(num) {
		tempNum = "";
		secondNum = parseFloat(num);
		if (!(isNaN(secondNum))) {
			tempSecondNum = secondNum;
		}
	}

	function operate(operator) {
		setSecondNum(tempNum);

		// 연산자이고 결과값이 들어있지 않고 이전입력이 숫자였으면 첫번째항임
		if (result === "" && checkFirstIsNum === true && operator !== "=") {
			this.operator = operator;
			operateFirstSentence();
		}
		// 연산자이고 결과값이 들어있고 이전입력이 숫자였으면 두번째항 이후임
		else if (result !== "" && checkFirstIsNum === true && operator !== "=") {
			operateNextSentence(operator);
			equalsCount = 0;
		}
		// 이전입력이 숫자입력이 아님 = 연산자입력후 다른 연산자 입력 = 연산자 바꿈
		else if (operator !== "=" && checkFirstIsNum === false) {
			if (this.operator !== operator) {
				equalsCount = 0;
				tempSecondNum = result;
				changeOperator(operator);
			}
		}
		// 연산자가 아닌 = 이 입력되면 바로 연산
		else if (operator === "=") {
			checkEquals = true;
			equalsCount++;
			operatorIsEquals();
		}
		changeTopScreen(topScreenList);
		checkPoint = 1;
	}

	function operateFirstSentence() {
		setFirstNumbyOperator(operator);
		tempTopScreenList += secondNum;
		topScreenList = secondNum + operator;
		changeNum();
		tempSecondNum = secondNum;
		startRequest();
		checkFirstIsNum = false;
	}

	function operateNextSentence(operator) {
		// = 연속으로 누르다가 연산자 바꿨을때라서 secondNum이 비어있음. operator도 바꿔줘야함.
		if (isNaN(secondNum) || secondNum === 0) {
			secondNum = result - firstNum;
			this.operator = operator;
			if (secondNum === 0 && (operator === "*" || operator === "/")) {
				secondNum = 1;
			}
		}
		tempSecondNum = secondNum;
		tempTopScreenList = topScreenList + result;
		topScreenList += (result + operator);
		startRequest();
		this.operator = operator;
		checkFirstIsNum = false;
	}

	function operatorIsEquals() {
		// = 을 한번만 눌렀을때 (첫번째 계산이여~)
		if ((isNaN(secondNum) || secondNum === "") && equalsCount < 2) {
			secondNum = firstNum;
			tempSecondNum = secondNum;
			checkFirstIsNum = true;
		}
		// = 을 여러번 누를때 (연속계산하는거)
		else if ((isNaN(secondNum) || secondNum === "") && equalsCount >= 2) {
			if (isNaN(tempSecondNum) || tempSecondNum === "") {
				tempSecondNum = result;
			}
			secondNum = tempSecondNum;
		}
		// 첫번째 숫자값이 비어있으면 result에 있는 값을 셋팅 1+2=3 -> 3+4=7 .. 3은 result였다가 firstNum이 되어야 함
		else if (isNaN(firstNum) || firstNum === "") {
			if (isNaN(result) || result === "") {
				result = secondNum;
			}
			firstNum = result;
		}
		topScreenList = "";
		if (!(operator === "" || operator === null)) {
			startRequest();
			checkEquals = false;
		}
	}

	function changeOperator(operator) {
		// 연산자가 바뀌면 기존 연산자를 변수에 집어넣음.
		this.operator = operator;

		// 화면표시를 위해서 넣어놓은 값이 없거나 혹은 결과값이 존재하지 않을때는 화면표시리스트를 0으로 찍음. 
		if (checkEquals === false
				&& (tempTopScreenList === "" || result === "")) {
			tempTopScreenList = 0;
			tempSecondNum = secondNum;
			secondNum = 0;
			firstNum = 0;
		}

		// 음수양수 변환을 눌렀었다면 값이 제대로 셋팅이 되어있지 않으므로 그거 해줌.
		else if (checkNumStyle === true) {
			if (isNaN(secondNum)) {
				secondNum = result;
			}
			tempTopScreenList = secondNum;
			firstNum = secondNum;
		} else {
			secondNum = tempSecondNum;
		}
		topScreenList = tempTopScreenList + operator;
		changeTopScreen(topScreenList);
	}

	function cancleData() {
		tempSecondNum = "";
		firstNum = "";
		secondNum = "";
		operator = "";
		topScreenList = "";
		tempTopScreenList = "";

		checkFirstIsNum = false;
		checkStartfromEquals = false;
		checkPoint = 1;
		checkNumStyle = false;

		num = "";
		tempNum = "";
		result = "";
		equalsCount = 0;

		changeTopScreen("");
		changeRowScreen(0);
	}

	function cancleNum() {
		checkPoint = 1;
		tempNum = "";
		changeRowScreen("0");
	}

	function deleteNum() {
		if (tempNum.length <= 1) {
			tempNum = 0;
			changeRowScreen("0");
		} else {
			tempNum = tempNum.toString().substring(0,
					(tempNum.toString()).length - 1);
			changeRowScreen(tempNum);
		}
	}

	function setFirstNumbyOperator(operator) {
		if (operator === "*" || operator === "/") {
			firstNum = 1;
		} else {
			firstNum = 0;
		}
	}

	function changeTopScreen(str) {
		document.getElementById("topScreen").value = str;
	}

	function changeRowScreen(str) {
		document.getElementById("rowScreen").value = str;
	}

	function changeNum() {
		var temp = 0;
		temp = firstNum;
		firstNum = secondNum;
		secondNum = temp;
	}

	function keyDown() {
		var keycode = event.keyCode;
		var realkey = String.fromCharCode(event.keyCode);
		if (keycode >= 49 && keycode <= 57) {
			putNum(keycode - 48);
		} else if (keycode >= 96 && keycode <= 105) {
			putNum(keycode - 96);
		} else if (keycode === 107 || keycode === 109 || keycode === 106
				|| keycode === 111 || keycode === 110 || keycode === 13) {
			switch (keycode) {
			case 107:
				operate("+");
				break;
			case 109:
				operate("-");
				break;
			case 106:
				operate("*");
				break;
			case 111:
				operate("/");
				break;
			case 110:
				putNum(".");
				break;
			case 13:
				operate("=");
				break;
			}
		} else if (keycode === 27) {
			cancleData();
		} else if (keycode === 8) {
			deleteNum();
		} else if (keycode === 67) {
			cancleData();
		} else if (keycode === 192) {
			changeNumStyle();
		}
	}
	document.onkeydown = keyDown;
</script>
</head>

<body>
	<form name="operator" method="POST">
		<table border="1" bgcolor="pink">
			<tr>
				<td colspan="4"><input type="text" id="topScreen"
					style="text-align: right;" readonly="readonly"></td>
			</tr>
			<tr>
				<td colspan="4"><input type="text" id="rowScreen" value="0"
					height="10" style="text-align: right;" readonly="readonly">
				</td>
			</tr>
			<tr align="center">
				<td><input type="button" value="CE" onclick="cancleNum()"
					class="btn"></td>
				<td><input type="button" value="C" onclick="cancleData()"
					class="btn"></td>
				<td><input type="button" value="+/-" onclick="changeNumStyle()"
					class="btn"></td>
				<td><input type="button" value="+"
					onclick="operate(this.value)" class="btn"></td>
			</tr>
			<tr align="center">
				<td><input type="button" value="7" onclick="putNum(this.value)"
					class="btn"></td>
				<td><input type="button" value="8" onclick="putNum(this.value)"
					class="btn"></td>
				<td><input type="button" value="9" onclick="putNum(this.value)"
					class="btn"></td>
				<td><input type="button" value="-"
					onclick="operate(this.value)" class="btn"></td>
			</tr>
			<tr align="center">
				<td><input type="button" value="4" onclick="putNum(this.value)"
					class="btn"></td>
				<td><input type="button" value="5" onclick="putNum(this.value)"
					class="btn"></td>
				<td><input type="button" value="6" onclick="putNum(this.value)"
					class="btn"></td>
				<td><input type="button" value="*"
					onclick="operate(this.value)" class="btn"></td>
			</tr>
			<tr align="center">
				<td><input type="button" value="1" onclick="putNum(this.value)"
					class="btn"></td>
				<td><input type="button" value="2" onclick="putNum(this.value)"
					class="btn"></td>
				<td><input type="button" value="3" onclick="putNum(this.value)"
					class="btn"></td>
				<td><input type="button" value="/"
					onclick="operate(this.value)" class="btn"></td>
			</tr>
			<tr align="center">
				<td><input type="button" value="0" onclick="putNum(this.value)"
					class="btn"></td>
				<td><input type="button" value="." onclick="putNum(this.value)"
					class="btn"></td>
				<td><input type="button" value="<-" onclick="deleteNum()"
					class="btn"></td>
				<td><input type="button" value="="
					onclick="operate(this.value)" class="btn"></td>
			</tr>
		</table>
	</form>
</body>
</html>