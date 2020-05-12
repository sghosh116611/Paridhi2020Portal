<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Paridhi 2020</title>
<%@ include file="../web/_head.jsp"%>
</head>
<style>
body {
	background: url("web/bg.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	background-position: center;
}
</style>
<body>
	<div class="container">
		<div class="jumbotron"
			style="background: transparent; text-align: center;">
			<h1>PARIDHI 2020</h1>
		</div>
		<div class="row">
			<button id="mrd" type="button" class="btn btn-danger btn-lg button"
				onclick="location.href='web/login_details.jsp'"
				style="margin: auto; display: block;">Main Registration
				Desk(MRD)</button>
		</div>
		<br>
		<div class="row">
			<button id="mrd" type="button" class="btn btn-danger btn-lg button"
				onclick="location.href='web/login_details.jsp'"
				style="margin: auto; display: block;">Registration Desk(RD)
			</button>
		</div>
		<br>
		<div class="row">
			<button id="mrd" type="button" class="btn btn-danger btn-lg button"
				onclick="location.href='web/login_details.jsp'"
				style="margin: auto; display: block;">Coordinator
				Registration Desk(CRD)</button>
		</div>
	</div>

</body>

</html>