<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div>
		<label for="cars">Select Employees:</label> <select name="email"
			id="email" multiple>
			<c:forEach items="${userList}" var="user">
				<option value="${user.getEmail()}">${user.getFirstName()}
					${user.getLastName()}</option>

			</c:forEach>
		</select>
	</div>

</body>
</html>