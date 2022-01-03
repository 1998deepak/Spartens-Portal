<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Policies</title>
<link rel="icon" href="../images/Krios-icon-header.png"
	type="image/icon type">
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!-- Bootstrap Styles-->
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<!-- FontAwesome Styles-->
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<!-- Morris Chart Styles-->
<link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
<!-- Custom Styles-->
<link href="assets/css/custom-styles.css" rel="stylesheet" />
<!-- Google Fonts-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="assets/js/Lightweight-Chart/cssCharts.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="./css/downloadButton.css" type="text/javascript"></script>
</head>
<style>
body {
	background-color: #E8E8E8;
}

#mydiv {
	width: 1200px;
	padding: 10px;
	border: 0.5px;
	-webkit-box-shadow: 0 30px 60px 0;
	margin: 20px;
	-webkit-border-radius: 10px 10px 10px 10px;
	border-radius: 4px 4px 4px 4px;;
	background: #fff;
	padding: 30px;
	position: relative;
	padding: 0px;
	-webkit-box-shadow: 0 30px 60px 0 rgba(0, 0, 0, 0.3);
	box-shadow: 0 30px 60px 0 rgba(0, 0, 0, 0.3);
	text-align: left;
}

button:hover {
	opacity: 0.8;
}

table, th, td {
	border: 1px;
}

th, td {
	padding: 7px;
	text-align: left;
}

.panel-group .panel+.panel {
	margin-top: -2px;
}
</style>
<body>
	<div>
		<jsp:include page="./components/userNavbar.jsp" />
	</div>
	<div
		style="position: absolute; left: 76px; top: 55px; padding-top: 6px; padding-bottom: 6px;"
		id="mydiv">
		<font color="black" style="font-family: sans-serif; font-size: 15px;">&nbsp;
			COMPANY POLICIES</font>
	</div>

	<div class="container" align="center" id="mydiv"
		style="position: absolute; left: 76px; top: 92px;">
		<table class="table table-hover" id="mydiv ">
			<thead>
				<tr class="table-active"
					style="border-top: 1px solid white; background-color: #36C5F0;">
					<th>Id</th>
					<th>Name</th>
					<th>Download</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${policyList}" var="policy">
					<tr class="table-danger">
						<td><c:set var="count" value="${count + 1}" scope="page" />
							<c:out value="${count}" /></td>
						<td>${policy.getPolicyName()}</td>
						<td><a href="/downloadPolicy/${policy.getPolicyId()}"><button
									style="color: green; border: none; background-color: white">
									<i class="material-icons "
										style="font-size: 34px; float: left;">cloud_download</i>
								</button></a></td>
						<td><a href="/viewFile/${policy.getPolicyId()}"><button
									class="btn btn-tab">
									<span class="glyphicon glyphicon-eye-open"></span>
								</button> </a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>