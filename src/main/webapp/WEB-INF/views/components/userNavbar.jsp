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

	<div class="navbar">
	<div style="position: absolute;left: 5px; top: -17px;">
  <a href="#"><img src="../images/Krios-icon-bg.png" height="70px" width="120px"></a></div>
  <div style="position: absolute;left: 103px; top: 7px;">
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
          <i class="fa fa-folder-open"></i>
          Documents
        </a>
      </li>
     <!--<li >
        <a href="#">
          <i class="fa fa-vcard"></i>
          Raise Ticket
        </a>
      </li>-->
  </ul>
  </div>
      <div style="position: absolute; left: 1100px; top: 7px;">
        <a href="#" >
          <span class="glyphicon glyphicon-user"></span>
         ${firstName}
        </a>
        <a class="dropdown-item" href="/logout"><span class="glyphicon glyphicon-log-out"></span>&nbspLogout</a>
        <!-- <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/logout">Logout</a>
          <a class="dropdown-item" href="#">About</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Contact-Us</a>
        </div> -->
      </div>
  </div>

</body>
</html>