<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NavBar</title>
</head>
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
	z-index: 9999;
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
<body>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="navbar">
	<div style="position: absolute;left: 5px; top: -17px;">
  <a href="#"><img src="../images/krios-icon.png" width="120px" style="padding-top:8px"></a></div>
  <div style="position: absolute;left: 115px; top: 7px;">
    <ul style="
    color: #42B5F4;">
      <li>
        <a  href="/userDashboard">
          <span class="glyphicon glyphicon-home"></span>
          Home
          </a>
        <a href="/editUser">
          <span class="glyphicon glyphicon-list-alt"></span>
          Employement Form
        </a>
        <a href="/doc">
          <span class="glyphicon glyphicon-folder-open"></span>&nbsp; Documents
        </a>
        <a href="/viewPolicy"><span class="glyphicon glyphicon-book"></span> Policies</a>
        <c:set var = "cname" scope="session" value = "${companyName}"/>
      <c:if test = "${not empty cname}">
        <a href="/AttendanceSheet">
         <span class="glyphicon glyphicon-file"></span>
          Attendance Sheet
        </a>	
        </c:if>  
      </li>
  </ul>
  </div>
      <div style="position: absolute; right: 5px; top: 7px;">
        <a href="#" >
          <span class="glyphicon glyphicon-user"></span>
         ${firstName}
        </a>
        <a class="dropdown-item" href="/logout"><span class="glyphicon glyphicon-log-out"></span>&nbspLogout</a>

      </div>
  </div>

</body>
</html>