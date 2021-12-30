<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

         
<form  method="post" action="send-otp" style="max-width: 420px; margin: 0 auto;">
<div class="border border-secondary rounded p-3">
    <div>
    <h2>Forgot Password</h2>
    <font color="red">${message2}</font>
</div>
    <div>
        <p>
            <input type="email" name="email" class="form-control" placeholder="Enter your e-mail" required autofocus/>
        </p>         
        <p class="text-center">
            <input type="submit" value="Send OTP" class="btn btn-primary" />
        </p>
    </div>
</div>
</form>
</body>
</html>