<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>User-Info</title>
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
</head>
<style>
body {
	background-color: #E8E8E8;
}

table {
	padding-left: 0.5px;
	padding-right: 0.5px;
}

#mydiv {
	width: 700px;
	height: 300px;
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

#mydiv2 {
	width: 336px;
	height: 300px;
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

#mydiv3 {
	width: 1048px;
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

button {
	background-color: #34AB53;
	color: white;
	padding: 7px 12px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	border-radius: 10px 10px 10px 10px;
}

button:hover {
	opacity: 0.8;
}

table, th, td {
	border: 1px;
}

tr, th, td {
	
}

.panel-group .panel+.panel {
	margin-top: -2px;
}
</style>
<body>
	<div>
		<jsp:include page="./components/financeNavbar.jsp" />
	</div>
	<div
		style="position: absolute; left: 169px; top: 60px; padding-top: 6px; padding-bottom: 6px;"
		id="mydiv3">
		<font color="black" style="font-family: sans-serif; font-size: 15px;">&nbsp&nbsp
			EMPLOYEE PROFILE</font>

	</div>
	<div id="mydiv2"
		style="position: absolute; left: 169px; top: 99px; padding-top: 6px; padding-bottom: 6px;">
		<div align="center">
			<img class="card-img-top" src="../images/men_avatar.png"
				alt="Card image cap" height="60%" width="60%">
			<div class="card-body">
				<h5 class="card-title">
					<b>${user.getFirstName()} ${user.getLastName()}</b>
				</h5>
				<p class="card-text"></p>

			</div>
		</div>
	</div>
	<div
		style="position: absolute; left: 512px; top: 92px; padding-top: 6px; padding-bottom: 6px;">

		<table id="mydiv" class="table table-hover">
			<tr style="background-color: #2196F3">
				<td><font color="white" size="4px"><b>Report</b></font></td>
				<td align="right"><input
					style="border-radius: 5px; color: black" type="month" id="start"
					name="start" value="2021-12"></td>
			</tr>

			<tr>
			<tr>
				<th>Email</th>
				<td>${user.getEmail()}</td>
			</tr>
			<tr>
				<th>User Name</th>
				<td>${user.getUserName()}</td>
			</tr>
			<tr>
				<th>Client Company Name</th>
				<td>${user.getClientCompanyName()}</td>
			</tr>
			<tr>
				<th>Uploaded Sheets</th>
				<td align="left">
					<table>
						<tr>
							<td></td>
							<td align="left">
								<!-- Button trigger modal -->

								<div>
									<button type="button" data-toggle="modal"
										data-target="#exampleModal" style="background-color: #42B5F4;">
										View Sheets</button>
								</div>
								<!-- Modal -->
								<div class="modal fade" id="exampleModal" tabindex="-1"
									role="dialog" aria-labelledby="exampleModalLabel"
									aria-hidden="true">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-header" align="left">
												<h4 class="modal-title" id="exampleModalLabel">ATTENDANCE
													SHEET</h4>
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
											</div>
											<div class="modal-body">
												<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
													prefix="c"%>
												<div>
													<table class="table table-hover">
														<thead>
															<tr class="table-active"
																style="border-top: 1px solid white; background-color: #36C5F0;">
																<th>Id</th>
																<th>Name</th>
																<th>Sheet-Of</th>
																<th>Upload Date</th>
																<th>Download Link</th>
																<th>Action</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${sheets}" var="sheet">
																<tr class="table-danger">
																	<td><c:set var="count" value="${count + 1}"
																			scope="page" /> <c:out value="${count}" /></td>
																	<td>${sheet.getSheetName()}</td>
																	<td>${sheet.getSheetOf()}</td>
																	<td>${sheet.getUploadDate()}</td>
																	<td><a href="/downloadSheet/${sheet.getSheetId()}">Download</a></td>
																	<td><a href="/deleteSheet/${sheet.getSheetId()}"><span
																			class="glyphicon glyphicon-trash" style="color: red"></span></a></td>
																</tr>
															</c:forEach>
														</tbody>
													</table>
												</div>

											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-secondary"
													style="background-color: red;" data-dismiss="modal">Close</button>
											</div>
										</div>
									</div>
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
</html>