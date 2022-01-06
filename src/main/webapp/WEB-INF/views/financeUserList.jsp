<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Calendar" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Finance-Dashboard</title>
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
	width: 900px;
	border-collapse: collapse;
}

th, td {
	font-size: 13px;
	padding: 4px;
}

tr.header {
	background-color: #BCBCBC;
}

#mydiv {
	width: 1189px;
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

#myInput {
	background-image: url('./images/');
	background-position: 5px 5px;
	background-repeat: no-repeat;
	width: 20%;
	font-size: 16px;
	padding: 1px ​0px 1px 35px;
	border: 1px solid #ddd;
	margin-bottom: 12px;
}
</style>
<body>
	<div>
		<jsp:include page="./components/financeNavbar.jsp" />
	</div>
	<div
		style="position: absolute; left: 70px; top: 60px; padding-top: 6px; padding-bottom: 6px;"
		id="mydiv">
		<font color="black" style="font-family: sans-serif; font-size: 15px;">&nbsp&nbsp
			EMPLOYEE PROFILES</font>

	</div>

	<div id="mydiv" style="position: absolute; left: 70px; top: 97px;">
	<form action="sortUserList" method="post">
		<table class="table table-hover">
			<thead>
				<tr>
					<!--  <td align="center">Show&nbsp;&nbsp; <select class="input100"
						style="padding: 7px; border-radius: 5px;" name="role">
							<option value="five">5</option>
							<option value="ten">10</option>
							<option value="fifteen">15</option>
							<option value="twenty">20</option>
							<option value="twentyfive">25</option>
					</select> <span class="focus-input100"></span> &nbsp;&nbsp;&nbsp;Entries
					</td>-->

					<td align="center"><i class="fa fa-filter"
						style="font-size: 25px"></i> Status &nbsp;&nbsp; <select
						class="input100" style="padding: 7px; border-radius: 5px;"
						name="uploadStatus">

							<option value="any">Any</option>
							<option value="pending">Pending</option>
							<option value="completed">Completed</option>
					</select> <span class="focus-input100"></span></td>
					<td align="center">
						<div>
							<i class="fa fa-calendar" style="font-size: 25px"></i> Date
							&nbsp;&nbsp; <input style="border-radius: 5px;" type="month"
								id="start" name="uploadDate"  value="${todaysDate}" required="required">
						</div>
					</td>
					<td align="center">
						<div>
							<button> Get User List </button>
						</div>
					</td>
					<td align="center">
						<div class="col input-group mb-3" style="padding: 3px;">
							<input type="text" id="myInput" onkeyup="myFunction()"
								placeholder="Search for names.." title="Type in a name"
								style="width: 215px; height: 38px;">
						</div>
					</td>
				</tr>
				<tr>
					<td align="center">Total Employees : &nbsp;&nbsp; 
						${userCount}
					</td>
					<td align="center">Attendance Shared By : &nbsp;&nbsp; 
						${completedCount}
					</td>
					<td align="center">Attendance Pending of : &nbsp;&nbsp; 
						${pendingCount}
					</td>
				</tr>
		</table>
		</form>
		<table class="table table-hover"
			style="background-color: white; size: 14px;" id="myTable">
			<thead>
				<tr class="header">
					<th style="font-weight: bold;">#</th>
					<th style="font-weight: bold;">Name</th>
					<th style="font-weight: bold;">Email</th>
					<th style="text-align: center" style="font-weight: bold;">Operation</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userList}" var="user">
					<tr>

						<th><c:set var="count" value="${count + 1}" scope="page" />
							<c:out value="${count}" /></th>
						<td>${user.getFirstName()} ${user.getMiddleName()}
							${user.getLastName()}</td>
						<td>${user.getEmail()}</td>

						<td align="center"><a
							href="/financeUserInfo/${user.getUserid()}"><button
									name="editbtn" class="btn col align-items-center">
									<i class="fa fa-eye"></i>
								</button></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<!--  <nav aria-label="Page navigation" style="float: right">
			<ul class="pagination">
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						<span class="sr-only">Previous</span>
				</a></li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
						class="sr-only">Next</span>
				</a></li>
			</ul>
		</nav>-->
	</div>

	<script>
		function myFunction() {
			var input, filter, table, tr, td, i, txtValue;
			input = document.getElementById("myInput");
			filter = input.value.toUpperCase();
			table = document.getElementById("myTable");
			tr = table.getElementsByTagName("tr");
			for (i = 0; i < tr.length; i++) {
				td = tr[i].getElementsByTagName("td")[0];
				if (td) {
					txtValue = td.textContent || td.innerText;
					if (txtValue.toUpperCase().indexOf(filter) > -1) {
						tr[i].style.display = "";
					} else {
						tr[i].style.display = "none";
					}
				}
			}
		}
	</script>
</body>
</html>