<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password form</title>
</head>
<body>

         
<form  method="post" action="change-password" style="max-width: 420px; margin: 0 auto;">
<div class="border border-secondary rounded p-3">
<h3> Enter New Password
</h3>
       <div>
        <p>
            <input type="text" name="newpassword" class="form-control" placeholder="EnterNew Password  Here" required autofocus/>
        </p>         
        <p class="text-center">
            <input type="submit" value="Change Password" class="btn btn-primary" />
        </p>
    </div>
</div>
</form>
</body>
</html>