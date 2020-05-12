<%@ page import="java.util.*" language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GID VALUE</title>
<%@ include file="../web/_head.jsp"%>
</head>
<body>
	<div class="container">
		<div class="jumbotron"
			style="background: transparent; text-align: center;">
			<h1>PARIDHI 2020</h1>
		</div>
		
		<div class = "gid">
			<h2>Your GID is <%= request.getAttribute("gid")%> </h2>
		</div>
	</div>

</body>
</html>