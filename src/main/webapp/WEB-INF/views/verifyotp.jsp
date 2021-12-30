<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

         
<form  method="post" action="verify-otp" style="max-width: 420px; margin: 0 auto;">
<div class="border border-secondary rounded p-3">
    <div class="alert alert-success" role="alert">
    We Have Sent Otp To Your Email...!!!
    <font color="red">${message1}</font>
 
</div>
    <div>
        <p>
            <input type="number" name="otp" class="form-control" placeholder="Enter Otp Here" required autofocus/>
        </p>         
        <p class="text-center">
            <input type="submit" value="Verify" class="btn btn-primary" />
        </p>
    </div>
</div>
</form>
</body>
</html>