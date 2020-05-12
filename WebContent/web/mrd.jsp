<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Registration Desk</title>
<%@ include file="../web/_head.jsp"%>
<style>
body {
	background: url("bg.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	background-position: center;
}
</style>
<script>
	function resetForm() {

		document.getElementById("myform").reset();

	}
</script>
</head>
<body>
	<div class="container">
		<div class="jumbotron"
			style="background: transparent; text-align: center;">
			<img src="P.png" height="100" width="100">
		</div>
		<div class="container-fluid">
			<legend style="text-align: center; padding: 2%;">Registration
				Details</legend>
			<form action="../UserAddServ" method="post" id="myform">
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="col control-label" for="first_name">First
								Name:</label>
							<div class="col">
								<input id="first_name" name="first_name" type="text"
									placeholder="Enter the first name"
									class="form-control input-md" required="">
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col control-label" for="middle_name">Middle
								Name:</label>
							<div class="col">
								<input id="middle_name" name="middle_name" type="text"
									placeholder="Enter the middle name"
									class="form-control input-md">
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col control-label" for="last_name">Last
								Name:</label>
							<div class="col">
								<input id="last_name" name="last_name" type="text"
									placeholder="Enter the last name" class="form-control input-md"
									required="">
							</div>
						</div>
					</div>

				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="col control-label" for="contact">Contact:</label>
							<div class="col">
								<input id="contact" name="contact" type="text"
									placeholder="Enter the Contact number"
									class="form-control input-md" required="">
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col control-label" for="email">Email:</label>
							<div class="col">
								<input id="email" name="email" type="email"
									placeholder="Enter the Email Address"
									class="form-control input-md" required="">
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col control-label" for="dob">College Name:</label>
							<div class="col">
								<input class="form-control" id="dob" name="dob" name="date"
									placeholder="Enter college name" type="text" required="" />
							</div>
						</div>
					</div>
				</div>
				<div class="row">

					<div class="col-md-4">
						<div class="form-group">
							<label class="col control-label" for="year">Year Of
								College</label>
							<div class="col">
								<select class="form-control" name="year" id="year" required="">
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
								</select>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col control-label" for="radio">Gender:</label>
							<div class="col">
								<div class="radio">
									<label><input type="radio" id="optradio"
										name="optradio" checked>Male</label>
								</div>
								<div class="radio">
									<label><input type="radio" id="optradio"
										name="optradio">Female</label>
								</div>
							</div>
						</div>
					</div>

				</div>

				<div class="row">
					<div class="col-md-4">
						<div class="col ">
							<button type="submit" class="btn btn-primary">Submit &
								Generate ID</button>
						</div>
					</div>
					<div class="col-md-4">
						<div class="col ">
							<button type="reset" class="btn btn-primary"
								onclick="resetForm();">Reset Fields</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>


</html>