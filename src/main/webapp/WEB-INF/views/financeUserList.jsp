<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>User-Dashboard</title>
<link rel="icon" href="./images/Krios-icon-header.png" type="image/icon type">
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="assets/js/Lightweight-Chart/cssCharts.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<style>
body{
	background-image:linear-gradient(rgba(0,0,0,0.5),rgba(0,0,0,0.5)),url("./images/userdashboard.jpg");
	background-size: cover;
	margin:0;
	padding:0;
	width:100%;
	height:100vh;
}
</style>
<body>
    <div>
		<jsp:include page="./components/financeNavbar.jsp" />
	</div>
	<div  style="padding:5%;padding-top:13%">
        <table id="dtBasicExample" class="table table-striped table-bordered table-sm" style="background-color: rgb(255, 255, 255);"
                cellspacing="0" width="100%">
                <thead style="background-color: white;">
                   <tr>

                   hgjh
                                        <th class="th-sm">Id
                                        </th>
                                        <th class="th-sm">Name
                                        </th>
                                        <th class="th-sm">Email
                                        </th>

                                         <th class="th-sm">Operation
                                        </th>
                    </tr>
                    <tr>
                        <th class="th-sm">Id
                        </th>
                        <th class="th-sm">Name
                        </th>
                        <th class="th-sm">Email
                        </th>

                         <th class="th-sm">Operation
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>Ganesh Chavan</td>
                        <td>chavanganesh806@gmail.com</td>
                        <td><button name="editbtn" class="btn col"><i class="fa fa-eye"></i></button>
                        </td>
                    </tr>

                    <tr>
                        <td>1</td>
                        <td>Ganesh Chavan</td>
                        <td>chavanganesh806@gmail.com</td>
                        <td><button name="editbtn" class="btn col"><i class="fa fa-eye"></i></button>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>Ganesh Chavan</td>
                        <td>chavanganesh806@gmail.com</td>
                        <td><button name="editbtn" class="btn col"><i class="fa fa-eye"></i></button>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>Ganesh Chavan</td>
                        <td>chavanganesh806@gmail.com</td>
                        <td><button name="editbtn" class="btn col"><i class="fa fa-eye"></i></button>
                        </td>
                    </tr>
                </tbody>

            </table>
	</div>

<footer>
	<div style="position: absolute; left: 500px; top: 620px;">
	<h4><jsp:include page="./components/footer.jsp" /></h4>
	</div>
	</footer>
</body>

</html>