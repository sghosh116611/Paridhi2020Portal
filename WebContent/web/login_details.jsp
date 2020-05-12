<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Details</title>
<%@ include file="../web/_head.jsp"%>
</head>
<body>
	<div class="container">
		<div class="jumbotron"
			style="background: transparent; text-align: center;">
			<h1>PARIDHI 2020</h1>
		</div>
		<form>
			<div class="form-group">
				<label for="username">Username</label> <input type="text"
					class="form-control" id="Username" aria-describedby="emailHelp"
					placeholder="Enter the username">
			</div>
			<div class="form-group">
				<label for="Password">Password</label> <input type="password"
					class="form-control" id="Password" placeholder="Password">
			</div>
			<button id="button" type="button" class="btn btn-primary"
				onclick="validate();">Submit</button>
		</form>
	</div>
</body>

<script type="text/javascript">
	function validate() {
		var username = document.getElementById("Username").value;
		var password = document.getElementById("Password").value;
		if (username == "mrd" && password == "fullded") {
			location.href = "mrd.jsp";
		} else if (username == "crd" && password == "leh") {
			location.href = "crd.jsp";
		} else if (username == "rd" && password == "pathetic") {
			location.href = "rd.jsp";
		} else {
			alert("ENTER CORRECT EMAIL OR PASSWORD!!")
			return true;
		}

	}
</script>
</html>