<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
body {
	margin: 0;
}

.navbar {
	overflow: hidden;
	background-color: #42B5F4 ;
	position: fixed;
	top: 0;
	width: 100%;
	height: 60px;
}

.navbar a {
	float: left;
	display: block;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 15px;
}
.main {
	padding: 16px;
	margin-top: 30px;
	height: 1500px; /* Used in this example to enable scrolling */
}
</style>
</head>
<body>
	<div class="navbar">
		<div style="position: absolute;left: 5px; top: -17px;">
		<a href="#"><img src="../images/krios-icon.png" width="120px" style="padding-top:8px"></a></div>
			<div style="position: absolute;left: 103px; top: 7px;">
		<ul style="
    color: #42B5F4;">
			<li><a href="/hrHomepage"><span class="glyphicon glyphicon-home"></span> Home</a> <a href="/addUserForm"><span class="glyphicon glyphicon-plus-sign"></span> Add
					Employee</a>
			<a href="/employeeDetails"><span class="glyphicon glyphicon-th-list"></span> Show Employee</a>
			<a href="/policiesForm"><span class="glyphicon glyphicon-book"></span> Policies</a>
			</li>
			<!-- <li><a href="/reports">Reports</a></li> -->
		</ul>
		</div>
		<div style="position: absolute; right: 5px; top: 7px;">
			<a href="#"> <span class="glyphicon glyphicon-user"></span>
				${firstName}
			</a> <a href="/logout"> <span class="glyphicon glyphicon-log-out"></span>&nbspLogout
			</a>
		</div>
	</div>
</body>
</html>