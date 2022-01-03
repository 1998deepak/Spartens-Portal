<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Policy Section</title>
</head>
<link rel="icon" href="../images/Krios-icon-header.png"
	type="image/icon type">
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
<style>
body {
	background-color: #E8E8E8;
}

table:hover {
	background-color: #E8E8E8;
}

button:hover {
	opacity: 0.8;
}

#mydiv {
	width: 1200px;
	padding: 10px;
	border: 0.5px;
	-webkit-box-shadow: 0 30px 60px 0;
	margin: 20px;
	-webkit-border-radius: 10px 10px 10px 10px;
	border-radius: 4px 4px 4px 4px;
	background: #fff;
	padding: 30px;
	position: relative;
	padding: 0px;
	-webkit-box-shadow: 0 30px 60px 0 rgba(0, 0, 0, 0.3);
	box-shadow: 0 30px 60px 0 rgba(0, 0, 0, 0.3);
}
</style>
<body>
	<div>
		<jsp:include page="./components/header2.jsp" />
	</div>
	<div
		style="position: absolute; left: 76px; top: 55px; padding-top: 6px; padding-bottom: 6px;"
		id="mydiv">
		<font color="black" style="font-family: sans-serif; font-size: 15px;">&nbsp;
			COMPANY POLICIES</font>
	</div>
	<div class="container" align="center" id="mydiv"
		style="position: absolute; left: 76px; top: 92px;">
		<table>
			<tbody>
				<tr>
					<td style="float: left">Upload Policy</td>
					<td align="center"><form method="post" action="/upload-File"
							encType="multipart/form-data">
							<input type="file" name="file" multiple required />
							<p style="color: red;">(upload only image, png type)</p></td>
					<td style="float: right;"><button type="submit">Upload</button></td>
					</form>
				</tr>
			</tbody>
		</table>
		<br> <br>

		<div>
			<table class="table table-hover">
				<thead>
					<tr class="table-active"
						style="border-top: 1px solid white; background-color: #36C5F0;">
						<th>Id</th>
						<th>Name</th>
						<th>Download Link</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${policyList}" var="policy">
						<tr class="table-danger">
							<td><c:set var="count" value="${count + 1}" scope="page" />
								<c:out value="${count}" /></td>
							<td>${policy.getPolicyName()}</td>
							<td><a href="/downloadPolicy/${policy.getPolicyId()}">Download</a></td>
							<td><a href="/deletePolicy/${policy.getPolicyId()}"><button
										class="btn  btn-tab">
										<i class="fa fa-trash-o"></i></a>
										
										<a
								href="/viewPDF/${policy.getPolicyId()}"><button
										class="btn btn-tab">
										<i class="fa fa-eye"></i>
									</button></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>