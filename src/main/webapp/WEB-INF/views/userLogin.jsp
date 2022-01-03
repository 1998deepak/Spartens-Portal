<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--  jsp page for user login
 * author : Deepak
 * Date : 23/11/2021
 * version : 1.0 -->

<!DOCTYPE html>
<html lang="en">
<head>
<title>User Login</title>
<link rel="icon" href="../images/Krios-icon-header.png"
	type="image/icon type">
<meta charset="UTF-8">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->

<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<style>
body {
	background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)),
		url("./images/home.jpg");
	height: 100vh;
	background-size: cover;
	background-repeat: no-repeat;
	background-position: center;
	background-attachment: fixed;
}

.myDiv1 {
	width: 100%;
	height: 100%;
	background: green;
}

.title {
	position: absolute;
	top: 55%;
	left: 50%;
	transform: translate(-50%, -50%);
}

.title h2 {
	color: white;
	font-size: 60px;
}

.login100-form-title {
	background-color: #3eadcf;
}

.login100-form-btn {
	background-color: #3eadcf;
}
</style>
<script>
function myFunction() {
  var x = document.getElementById("myInput");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
$(function () {
    TriggerAlertClose();
});

function TriggerAlertClose() {
    window.setTimeout(function () {
        $(".alert").fadeTo(1000, 0).slideUp(1000, function () {
            $(this).remove();
        });
    }, 5000);
}
</script>

<body>
<c:set var = "message" scope="page" value = "${message}"/>
      <c:if test = "${not empty message}">
<div class="alert alert-success" role="alert" style="width: 300px">
${message}
</div>
</c:if>
<c:set var = "wrongmessage" scope="page" value = "${wrongmessage}"/>
      <c:if test = "${not empty wrongmessage}">
<div class="alert alert-danger" role="alert" style="width: 300px">
${wrongmessage}
</div>
</c:if>
	<div align="center" class="title"
		style="position: absolute; left: 400px; top: 300px;">
		<font size="45px" color="white"><b>Welcome to Krios Portal</b></font>
	</div>
	<div style="position: absolute; left: 800px; top: 50px;">
		<div class="container">
			<div class="wrap-login100">
				<form class="login100-form validate-form p-l-55 p-r-55 p-t-178"
					action="checklogin" method="post">
					<span class="login100-form-title">LOGIN</span> 
					
					<div class="wrap-input100 validate-input m-b-16">
						<select class="input100" name="roleName" required="required">
							<option value="" selected="true" disabled="disabled">Login As</option>
							<c:forEach items="${roles}" var="roles">
							<c:if test="${roles.roleName ne 'Super Admin'}">		
								<option value="${roles.roleName}">${roles.roleName}</option>
							</c:if>
							</c:forEach>
						</select><span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter username">
						<input class="input100" type="text" name="username"
							placeholder="Username"> <span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Please enter password">
						<input class="input100" type="password" name="password"
							placeholder="Password" id="myInput"> <span class="focus-input100"></span>
					</div><br>
					<div style="position: absolute; left: 80px;">
					<input type="checkbox" onclick="myFunction()"> Show Password&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="/forgotemailform"> Forgot Password?</a>
					</div>
					<br><br>
					<div class="container-login100-form-btn">
						<button class="login100-form-btn" type="submit">LOGIN</button>
					</div>
					<br>
					<br>
				</form>
			</div>
		</div>
	</div>


	<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>