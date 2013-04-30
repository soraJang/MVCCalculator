<%@page import="java.text.DecimalFormatSymbols"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.math.RoundingMode"%>
<%@page import="java.math.BigDecimal"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	BigDecimal result = (BigDecimal) request.getAttribute("result");
	DecimalFormat numformat = new DecimalFormat(
			"###############.###############");
	String strResult = numformat.format(result.doubleValue());

	response.getWriter().print(strResult);
%>
<%-- ${result} --%>