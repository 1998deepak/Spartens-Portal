<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="./images/Krios-icon-header.png"
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
table {
	width: 900px;
	border-collapse: collapse;
}
th, td {
	font-size: 13px;
	padding: 4px;
}
tr.header {
	background-color: #36C5F0;
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
.buttondown {
	background-color: #34AB53;
	color: white;
	padding: 7px 15px;
	margin: 4px 0;
	border: none;
	cursor: pointer;
	border-radius: 6px 6px 6px 6px;
}
.buttondown:hover {
	opacity: 0.8;
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
.height {
    height: 100vh
}
.form {
    position: relative
}
.form .fa-search {
    position: absolute;
    top: 20px;
    left: 20px;
    color: #9ca3af
}
.form span {
    position: absolute;
    right: 17px;
    top: 13px;
    padding: 2px;
    border-left: 1px solid #d1d5db
}
.left-pan {
    padding-left: 7px
}
.left-pan i {
    padding-left: 10px
}
.form-input {
    height: 55px;
    text-indent: 33px;
    border-radius: 10px
}
.form-input:focus {
    box-shadow: none;
    border: none
}
.btn-tab:hover{
background-color:white;
}
.btn{padding:1px 6px !important}
</style>
<title>Employee Details</title>
<link rel="icon" href="./images/Krios-icon-header.png"
	type="image/icon type">
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div>
		<jsp:include page="./components/header2.jsp" />
	</div>
	<font color="red">&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp &nbsp
		&nbsp&nbsp&nbsp&nbsp ${message1}</font>

	<div
		style="position: absolute; left: 70px; top: 60px; padding-top: 6px; padding-bottom: 16px;"
		id="mydiv">
		<font color="black" style="font-family: sans-serif; font-size: 15px;">&nbsp&nbsp
			EMPLOYEE PROFILES</font>
		<div class="container "
			style="position: absolute;  top: 2px;">
			          <i class="glyphicon glyphicon-search" style="position:absolute;top:1px;float:right;padding: 5px;margin-left: 82%;font-size:26px;color:gray;"></i>
			<input type="search" style="float:right;padding:6px;margin-right:12%;border:2px solid gray;border-radius:4px;" placeholder=" Search for Employee" id="myInput"
				onkeyup="myFunction()">
		</div>

        <div  style="position:absolute;top: 1px;margin-left:89%">
           <a href="/export" style=" float:right;text-align: center; display: block;">
             <button class="  buttondown"  ><span  class="glyphicon glyphicon-save-file" style="font-size:15px"></span>&nbsp;&nbsp;&nbsp;Download</button>
           </a>

        </div>


	</div>
	<div style="position: absolute; left: 70px; top: 109px;" id="mydiv"
		class="table-responsive">
		<table class="table table-hover"
			style="background-color: white; size: 14px;" id="myTable">
			<thead>
				<tr style="border-top: 1px solid white;" class="header">
					<th style="font-weight: bold;">#</th>
					<th style="font-weight: bold;">Full Name</th>
					<th style="font-weight: bold;">Email-ID</th>
					<th style="font-weight: bold;">Mobile</th>
					<th style="font-weight: bold;">Position</th>
					<th style="font-weight: bold;text-align:center">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userList}" var="user">

					<tr>
						<c:set var="count" value="${count + 1}" scope="page" />
						<th scope="row"><c:out value="${count}" /></th>
						<td>${user.getFirstName()} ${user.getMiddleName()}
							${user.getLastName()}</td>
						<td>${user.getEmail()}</td>
						<td>${user.getMobile()}</td>
						<td></td>
						<td align="center">
						        <a href="/viewForm/${user.getUserid()}">
						        <button class="btn btn-tab">
									<span class="glyphicon glyphicon-eye-open"></span>
								</button></a>&nbsp&nbsp
								<a href="/updateForm/${user.getUserid()}">
								<button class="btn  btn-tab">
									<span class="glyphicon glyphicon-edit"></span>
								</button></a>&nbsp&nbsp
								<a href="/deleteEmployee/${user.getUserid()}">
                                	<button class="btn  btn-tab">
                                		<span class="glyphicon glyphicon-trash"></span>
                                    </button></a>&nbsp&nbsp

						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
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