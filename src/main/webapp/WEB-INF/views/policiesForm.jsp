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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
body {
	background-color: #E8E8E8;
}
table li:hover {
	background-color: #E8E8E8;
}
.sbtn{
background-color:#E8E8E8;
}
.sbtn:hover{
	background-color:white;
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
	<div class="row"
		style="position: absolute; left: 76px; top: 55px; padding-top: 6px; padding-bottom: 6px;"
		id="mydiv">

		<font class="col-md-6" color="black" style="font-family: sans-serif; font-size: 15px;">&nbsp;
			COMPANY POLICIES</font>
		<div class="col-md-6"  >
	        <form style="float:right"  class="row" method="post" action="/upload-File" encType="multipart/form-data">
        		<input class="col-md-6"  type="file" name="file" style="border:1px solid gray; padding:7px;border-radius:3px;box-shadow: 0px 2px 2px gray;border-top-right-radius:0px;border-bottom-right-radius:0px;width:65%"  multiple required />
         	     <button class="btn col-md-6" style="padding: 1px 4px;background-color:green;color:white;width:34%;border-radius:3px;box-shadow: 0px 2px 2px gray;border-top-left-radius:0px;border-bottom-left-radius:0px"> <span class="material-icons " style="font-size: 34px;float:left;">cloud_upload</span><span style="font-size:16px;top:7px;left:46px;position:absolute;">Upload</span></button>
            </form>
        </div>
	</div>
	<div class="container"  id="mydiv"
		style="position: absolute; left: 76px; top: 109px;">


	
									<div>
										<table class="table table-hover">
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
														<td><c:set var="count" value="${count + 1}"
																scope="page" /> <c:out value="${count}" /></td>
														<td>${policy.getPolicyName()}</td>
														<td><a href="/downloadPolicy/${policy.getPolicyId()}">
														     <button     style=" color:green;border:none;background-color:white  "> <i class="material-icons " style="font-size: 34px;float:left;">cloud_download</i></button>
														 </a></td>
														<td><a class="btn sbtn"   href="/deletePolicy/${policy.getPolicyId()}"><span class="glyphicon glyphicon-trash"></span></a>&nbsp;&nbsp;&nbsp;
																<a class="btn sbtn"   href="/viewPDF/${policy.getPolicyId()}"><span class="glyphicon glyphicon-eye-open"></span></a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
									</div>
</body>
</html>