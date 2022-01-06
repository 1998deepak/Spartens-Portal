<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
<link rel="icon" href="../images/Krios-icon-header.png"
	type="image/icon type">
</head>
<style>
.form-gap {
    padding-top: 70px;
}

body {
	background-color: #E8E8E8;
}
button {
	background-color: #42B5F4;
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

</style>
<body>
<div class="form-gap"></div>
<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
              <div class="panel-body">
                <div class="text-center">
                  <h3><i class="fa fa-lock fa-4x"></i></h3>
                  <h2 class="text-center">Forgot Password?</h2>
                  <p>You can reset your password here.</p>
                  <p><font color="red">${message2}</font></p>
                  <div class="panel-body">
    
                    <form id="register-form" role="form" autocomplete="off" class="form" method="post" action="/send-otp">
    
                      <div class="form-group">
                        <div class="input-group">
                          <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                          <input id="email" name="email" placeholder="email address" class="form-control"  type="email">
                        </div>
                      </div>
                      <div class="form-group">
                        <button name="recover-submit" value="Reset Password" type="submit">Reset Password</button>
                      </div>
                      
                      <input type="hidden" class="hide" name="token" id="token" value=""> 
                    </form>
    
                  </div>
                </div>
              </div>
            </div>
          </div>
	</div>
</div>
</body>
</html>