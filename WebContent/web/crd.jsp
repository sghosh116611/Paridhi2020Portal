<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Coordinator Registration Desk</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<%@ include file="../web/_head.jsp"%>
</head>
<style>
body {
	background: url("bg.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	background-position: center;
}

table {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

table td, table th {
	border: 1px solid #ddd;
	padding: 8px;
}

table tr:nth-child(even) {
	background-color: #9ac2c9;
}

table tr:hover {
	background-color: #ddd;
}

table th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #8aa1b1;
	color: white;
}
</style>
<body>
	<br>
	<br>
	<br>
	<div class="container">
		<div class="jumbotron"
			style="background: transparent; text-align: center;">
			<img src="P.png" height="100" width="100">
			<h2>Coordinator Registration Desk</h2>
		</div>
		<div class="container" style="margin: auto; text-align: center;">
			<form action="#" method="post" id="myform" class="form">

				<br> <br> <span class="unam">Domain Name: </span>&nbsp; <select
					class="unamee" name="domain" id="domain">
					<option class="unamee" value="" selected="selected">---
						Please select ---</option>
					<option class="unamee" value="Robotics">Robotics</option>
					<option class="unamee" value="Coding">Coding</option>
					<option class="unamee" value="Gaming">Gaming</option>
					<option class="unamee" value="Electrical">Electrical</option>
					<option class="unamee" value="Civil">Civil</option>
					<option class="unamee" value="General Events">General</option>

					<br>
					<br>
				</select> <input type="button" btnn3 class=" unamee btnn3" name="submit"
					class="button" value="CHECK EVENT LIST" onclick="validate()">
				<br> <br> <br> <span class="unam">Event Name:
					&nbsp;</span> <select class="unamee" name="event" id="event">


					<!-- ROBOTICS -->

					<option value="" selected="selected">--- Please select ---</option>
					<option id="R1" value="Irons Heart">Iron's Heart</option>
					<option id="R2" value="Dawn of Justice">Dawn of Justice</option>
					<option id="R3" value="Quartro Claw Fight">Quatro Claw
						Fight</option>
					<option id="R4" value="Age of extinction">Age of
						Extinction</option>
					<option id="R5" value="Starwars(onspot)">Star Wars(onspot)</option>
					<option id="R6" value="Robo Clash Royale(Onspot)">Robo
						Clash Royale(Onspot)</option>
					<option id="R7" value="Coloured Stack">Coloured Stack</option>
					<option id="R8" value="Optimus Line">Optimus Line</option>
					<option id="RC1" value="Robotics1 Combo">Manual Combo</option>
					<option id="RC2" value="Robotics2 Combo">Autonomous Combo</option>

					<!-- CODING -->

					<option id="C1" value="Code Nova">Code Nova</option>
					<option id="C2" value="Code Xtreme">Code Xtreme</option>
					<option id="C3" value="Bug Hunt(onspot)">Bug Hunt(onspot)</option>
					<option id="C4" value="Web o Philia">Web-o-Philia</option>


					<!-- GAMING -->

					<option id="G1" value="PUBG Solo">PUBG Solo</option>
					<option id="G2" value="PUBG Squad">PUBG Squad</option>
					<option id="G3" value="CS GO">CS GO</option>
					<option id="G4" value="Kick O Mania">Kick O Mania</option>
					<option id="G5" value="Dota 2">DOTA 2</option>
					<option id="G6" value="NFS(onspot)">NFS(onspot)</option>
					<option id="G7" value="Pes(onspot)">PES 20(onspot)</option>


					<!-- Electrical -->

					<option id="E1" value="Electro Blast">Electro Blast</option>
					<option id="E2" value="Wire O Mania(onspot)">Wire O
						Mania(onspot)</option>

					<!-- CIVIL -->

					<option id="CE1" value="Setu Bandhan">Setu Bandhan</option>
					<option id="CE2" value="Mega Arch">Mega Arch</option>
					<option id="CE3" value="Track O Treasure">Track O Treasure</option>
					<option id="CE4" value="Cad Storm">Cad Storm</option>
					<option id="CE5" value="Cad Storm Beta">Cad Storm(Beta)</option>
					<option id="CEC" value="Civil Combo">Civil Combo</option>

					<!-- GENERAL --> <

					<!-- <option id="GE1" value="Pubg">Pubg</option> -->
					<option id="GE1" value="Darts">Darts</option>
					<option id="GE2" value="Carrom">Carrom</option>
					<option id="GE3" value="Chess">Chess</option>
					<option id="GE4" value="B-Plan">B-Plan</option>
					<option id="GE5" value="Table Tennis">Table Tennis</option>
					<option id="GE6" value="Innovation Challenge">Innovation
						Challenge</option>
					<option id="GE7" value="Debate">Debate</option>
					<option id="GE8" value="Quiz">Quiz</option>
					<option id="GE9" value="Vagapinups">Vagapinups</option>
					<option id="GE10" value="Videography">Videography</option>
					<option id="GEC" value="Photography+Videography Combo">Photography
						Combo</option>



				</select> <br> <br> <span class="unam">Type: </span>&nbsp; <select
					class="unamee" name="type" id="type">
					<option class="unamee" value="" selected="selected">---
						Please select ---</option>
					<option class="unamee" value="played">Played</option>
					<option class="unamee" value="unplayed">Unplayed</option>
					<br>
					<br>
				</select> </select> <br> <br>
				<button type="button" onclick="search1()">Check TID</button>
			</form>
		</div>


		<br> <br>
		<!-- Display through ajax -->

		<div id="my_data"></div>
	</div>

</body>
</html>


<!-- Register Button On Click -->
<script>
	function checked(check_id) {
		var tid = document.getElementById(check_id).value;
		var event = document.getElementById("event").value;
		
		$.ajax({
			url : '../UnPlayedServ',
			type : 'POST',
			dataType : 'text',
			data : {
				'action' : 'checked',
				'tid' : tid,
				'event' : event,
			},
			success : function(data) {
				/* alert("success data" + data); */
				/* if (str == data) { */
				$('#check').html("Played")
				/* 	alert("Data is not tere");

				} else {
					$('#my_data').html(data);
					

					// $('#myform')[0].reset();
				} */
			}
		});

	}

	function search1() {
		var str = "";
		var event = $('#event').val();
		var type = $('#type').val();

		$.ajax({
			url : '../CrdServ',
			type : 'POST',
			dataType : 'text',
			data : {
				'action' : 'search1',
				'event' : event,
				'type' : type,
			},
			success : function(data) {
				/* alert("success data" + data); */
				/* if (str == data) { */
				$('#my_data').html(data);
				/* 	alert("Data is not tere");

				} else {
					$('#my_data').html(data);
					

					// $('#myform')[0].reset();
				} */
			}
		});

	}

	//<!-- Event Disabling Function on domain selection -->
	function validate() {
		var domainDropValue = $("#domain").val();

		if (domainDropValue === "") {
			$("#domain").focus();
		} else if (domainDropValue === "Robotics") {

			for (var i = 11; i <= 40; i++)
				document.getElementById("event").options[i].disabled = true;

		}

		else if (domainDropValue === "Coding") {
			for (var i = 1; i <= 40; i++)
				if (i >= 11 && i <= 14)
					document.getElementById("event").options[i].disabled = false;
				else
					document.getElementById("event").options[i].disabled = true;

		}

		else if (domainDropValue === "Gaming") {
			for (var i = 1; i <= 40; i++)
				if (i >= 15 && i <= 21)
					document.getElementById("event").options[i].disabled = false;
				else
					document.getElementById("event").options[i].disabled = true;

		} else if (domainDropValue === "Electrical") {
			for (var i = 1; i <= 40; i++)
				if (i >= 22 && i <= 23)
					document.getElementById("event").options[i].disabled = false;
				else
					document.getElementById("event").options[i].disabled = true;

		} else if (domainDropValue === "Civil") {
			for (var i = 1; i <= 40; i++)
				if (i >= 24 && i <= 29)
					document.getElementById("event").options[i].disabled = false;
				else
					document.getElementById("event").options[i].disabled = true;

		}

		else if (domainDropValue === "General Events") {
			for (var i = 1; i <= 29; i++)
				document.getElementById("event").options[i].disabled = true;

		}

	}
</script>
</body>
</html>