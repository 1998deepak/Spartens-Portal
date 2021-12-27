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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

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
	width: 1189px;
	padding: 10px;
	border: 0.5px;
	-webkit-box-shadow: 0 30px 60px 0;
	margin: 20px;
	-webkit-border-radius: 10px 10px 10px 10px;
	border-radius: 10px 10px 10px 10px;
	background: #fff;
	padding: 30px;
	position: relative;
	padding: 0px;
	-webkit-box-shadow: 0 30px 60px 0 rgba(0, 0, 0, 0.3);
	box-shadow: 0 30px 60px 0 rgba(0, 0, 0, 0.3);
	text-align: left;
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
		<jsp:include page="./components/financeNavbar.jsp" />
	</div>
	<div style="position: absolute; left: 10%; top: 20%;">
	 <div class="row gutters-sm " >
                <div class="col-md-4 mb-3" >
                  <div class="card" style="margin: 4%;padding-top:180px;padding-left:180px;padding-right:90% ">
                    <div class="card-body" >
                      <div class="d-flex flex-column align-items-center text-center">
                        <img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="Admin" class="rounded-circle" width="30%" >
                        <div class="mt-3">
                          <h4>Ganesh Chavan </h4>
                           <p class="text-secondary mb-1">chavanganes806@gmail.com</p>
                           <button class="btn btn-primary" >Client Employee</button>
                         </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-md-8 " >
                    <div class="card mb-3" style="margin-left: 52%;border-radius: 2px;margin-right:-490px" >
                      <div class="card-header" style="padding: 2%;background-color: #2196F3;font-size: medium;color: white;">
                        <b style="float:left">Report</b>
                          <div  class="col-sm-3"  style="padding:1px;margin-right:6%;float:right" >
                             <input style="border-radius:5px;color:black" type="month" id="start" name="start" min="2021-12" value="2021-12">
                         </div>
                      </div>
                      <div class="card-body">

                        <div class="row">
                          <div class="col-sm-3">
                            <h6 class="mb-0">Full Name</h6>
                          </div>
                          <div class="col-sm-9 text-secondary">
                              Ganesh Chavan
                          </div>
                        </div>
                        <hr>
                        <div class="row">
                          <div class="col-sm-3">
                            <h6 class="mb-0">Email</h6>
                          </div>
                          <div class="col-sm-9 text-secondary">

                            chavanganes806@gmail.com
                          </div>
                        </div>
                        <hr>
                        <div class="row">
                          <div class="col-sm-3">
                            <h6 class="mb-0">User Id</h6>
                          </div>
                          <div class="col-sm-9 text-secondary">
                              chavanganes806
                          </div>
                        </div>
                        <hr>
                        <div class="row">
                          <div class="col-sm-3">
                            <h6 class="mb-0">File Uploaded</h6>
                          </div>
                          <div class="col-sm-9 text-secondary">
                            3 Hours
                          </div>
                        </div>


                      </div>
                    </div>



                  </div>
           </div>
	</div>

<footer>
	<div style="position: absolute; left: 500px; bottom: 10px;">
	<h4><jsp:include page="./components/footer.jsp" /></h4>
	</div>
	</footer>
</body>

</html>