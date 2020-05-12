<%@page import="java.io.PrintWriter"%>
<%@ page import = "java.util.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TID SHOW </title>
</head>
<body>
<% List<String> res = (List<String>)request.getAttribute("TID"); %>
<%
PrintWriter ot = response.getWriter();
for(String temp:res) 
	if(temp.charAt(0)=='G')
		ot.print("<h3>"+temp+"</h3>");
	else
	ot.print("<h3>The tid is: "+temp+"</h3>");
%>
</body>
</html>