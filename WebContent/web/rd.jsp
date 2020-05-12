<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Desk</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<%@ include file="../web/_head.jsp"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<style>
body {
	background: url("bg.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	background-position: center;
}
</style>
<body class="container" style="margin: auto; text-align: center;">
	<img src="P.png" height="100" width="100">
	<div class="login">
		<h1>Registration Desk</h1>
	</div>
	<form id="myform" class="form" action="../RegistrationServ">

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
			<option id="R3" value="Quartro Claw Fight">Quatro Claw Fight</option>
			<option id="R4" value="Age of extinction">Age of Extinction</option>
			<option id="R5" value="Starwars(onspot)">Star Wars(onspot)</option>
			<option id="R6" value="Robo Clash Royale(Onspot)">Robo Clash
				Royale(Onspot)</option>
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



		</select> <br> <br>
		<!-- <input type="button" name="submit "
			class="button btnn2" value="CHECK FOR TEAMS" onclick="checktid()"><br> -->
		<br> <span class="unam">General ID 1:</span> &nbsp;<input
			class="unamee" type="text" name="id1" id="id1"><br> <br>
		<span class="unam">General ID 2:</span> &nbsp;<input class="unamee"
			type="text" name="id2" id="id2"><br> <br> <span
			class="unam"> General ID 3:</span> &nbsp;<input class="unamee"
			type="text" name="id3" id="id3"><br> <br> <span
			class="unam">General ID 4:</span> &nbsp;<input class="unamee"
			type="text" name="id4" id="id4"><br> <br> <span
			class="unam">General ID 5:</span> &nbsp;<input class="unamee"
			type="text" name="id5" id="id5"><br> <br> <span
			class="unam">Contact:</span> &nbsp;<input class="unamee" type="text"
			name="contact" id="contact" required=""><br> <br>


		<button class="reg1 btnnnn" type="button" onclick="fees()">
			<span class="unam">Show Registration Fees</span>
		</button>
		<br> <br> <span class="unam reg1"> Amount:</span> &nbsp;<input
			class="unamee reg1" type="text" name="amt" id="amt" required=""><br>

		<button id="submit" type="submit"">Register and generate TID</button>
	</form>

	<!-- Display through ajax -->
	<br>
	<button id="reset" type="button" onclick="reset();">Reset the
		GID fields.</button>

	<div id="data"></div>
</body>
</html>


<!-- Register Button On Click -->
<script>
	document.getElementById("id1").defaultValue = "NULL";
	document.getElementById("id2").defaultValue = "NULL";
	document.getElementById("id3").defaultValue = "NULL";
	document.getElementById("id4").defaultValue = "NULL";
	document.getElementById("id5").defaultValue = "NULL";

	function reset() {
		document.getElementById("id1").value = "NULL";
		document.getElementById("id2").value = "NULL";
		document.getElementById("id3").value = "NULL";
		document.getElementById("id4").value = "NULL";
		document.getElementById("id5").value = "NULL";
	}

	function fees() {
		var event = $("#event").val();

		//fees
		if (event === "Irons Heart") {
			document.getElementById('amt').value = 150;
		} else if (event === "Dawn of Justice") {
			document.getElementById('amt').value = 150;
		} else if (event === "Quartro Claw Fight") {
			document.getElementById('amt').value = 150;
		} else if (event === "Age of extinction") {
			document.getElementById('amt').value = 200;
		} else if (event === "Starwars(onspot)") {
			document.getElementById('amt').value = 50;
		} else if (event === "Robo Clash Royale(Onspot)") {
			document.getElementById('amt').value = 50;
		} else if (event === "Coloured Stack") {
			document.getElementById('amt').value = 200;
		} else if (event === "Optimus Line") {
			document.getElementById('amt').value = 200;
		} else if (event === "Robotics1 Combo") {
			document.getElementById('amt').value = 400;
		} else if (event === "Robotics2 Combo") {
			document.getElementById('amt').value = 300;
		}

		else if (event === "Code Xtreme") {
			document.getElementById('amt').value = 150;
		} else if (event === "Code Nova") {
			document.getElementById('amt').value = 100;
		} else if (event === "Web o Philia") {
			document.getElementById('amt').value = 100;
		} else if (event === "Bug Hunt(onsopot)") {
			document.getElementById('amt').value = 100;
		}

		else if (event === "Electro Blast") {
			document.getElementById('amt').value = 80;
		} else if (event === "Wire O Mania(onspot)") {
			document.getElementById('amt').value = 30;
		}

		else if (event === "NFS(onspot)") {
			document.getElementById('amt').value = 70;
		} else if (event === "Pes(onspot)") {
			document.getElementById('amt').value = 40;
		} else if (event === "CS GO") {
			document.getElementById('amt').value = 600;
		} else if (event === "Kick O Mania") {
			document.getElementById('amt').value = 70;
		} else if (event === "PUBG Solo") {
			document.getElementById('amt').value = 50;
		} else if (event === "PUBG Squad") {
			document.getElementById('amt').value = 280;
		} else if (event === "Dota 2") {
			document.getElementById('amt').value = 600;
		}

		else if (event === "Setu Bandhan") {
			document.getElementById('amt').value = 80;
		} else if (event === "Track O Treasure") {
			document.getElementById('amt').value = 70;
		} else if (event === "Mega Arch") {
			document.getElementById('amt').value = 150;
		} else if (event === "Civil Combo") {
			document.getElementById('amt').value = 140;
		} else if (event === "Cad Storm") {
			document.getElementById('amt').value = 70;
		}else if (event === "Cad Storm Beta") {
			document.getElementById('amt').value = 70;
		}

		else if (event === "Carrom") {
			document.getElementById('amt').value = 80;
		} else if (event === "Chess") {
			document.getElementById('amt').value = 40;
		} else if (event === "Table Tennis") {
			document.getElementById('amt').value = 70;
		} else if (event === "Innovation Challenge") {
			document.getElementById('amt').value = 100;
		} else if (event === "Debate") {
			document.getElementById('amt').value = 50;
		} else if (event === "Darts") {
			document.getElementById('amt').value = 40;
		} else if (event === "B-Plan") {
			document.getElementById('amt').value = 50;
		} else if (event === "Quiz") {
			document.getElementById('amt').value = 100;
		} else if (event === "Vagapinups") {
			document.getElementById('amt').value = 0;
		} else if (event === "Videography") {
			document.getElementById('amt').value = 0;
		} else if (event === "Photography+Videography Combo") {
			document.getElementById('amt').value = 0;
		}
	}

	//<!-- Event Disabling Function on domain selection -->
	function validate() {
		var domainDropValue = $("#domain").val();

		if (domainDropValue === "") {
			$("#domain").focus();
		} else if (domainDropValue === "Robotics") {
			for(var i = 1; i <=40; i++)
				if( i>= 1 && i<=10)
					document.getElementById("event").options[i].disabled = false;
				else
					document.getElementById("event").options[i].disabled = true;
		
		}

		else if (domainDropValue === "Coding") {
			for(var i = 1; i <=40; i++)
				if( i>= 11 && i<=14)
					document.getElementById("event").options[i].disabled = false;
				else
					document.getElementById("event").options[i].disabled = true;
				
			

		}

		else if (domainDropValue === "Gaming") {
			for(var i = 1; i <=40; i++)
				if( i>= 15 && i<=21)
					document.getElementById("event").options[i].disabled = false;
				else
					document.getElementById("event").options[i].disabled = true;
		

		} else if (domainDropValue === "Electrical") {
			for(var i = 1; i <=40; i++)
				if( i>= 22 && i<=23)
					document.getElementById("event").options[i].disabled = false;
				else
					document.getElementById("event").options[i].disabled = true;
			
		} else if (domainDropValue === "Civil") {
			for(var i = 1; i <=40; i++)
				if( i>= 24 && i<=29)
					document.getElementById("event").options[i].disabled = false;
				else
					document.getElementById("event").options[i].disabled = true;
			

		}

		else if (domainDropValue === "General Events") {
			for(var i = 1; i <=40; i++)
				if( i>= 30 && i<=40)
					document.getElementById("event").options[i].disabled = false;
				else
					document.getElementById("event").options[i].disabled = true;
		}

		

	}
</script>
</body>
</html>
