<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<jsp:include page="../common/externalfiles.jsp"></jsp:include>

</head>
<body>




	<form action="new" method="post">


		<div class="form-group">
			<label for="userName">User Name</label> <input type="text"
				class="form-control" id="userName" name="userName"
				placeholder="Enter user Name">
		</div>

		<div class="form-group">
			<label for="userAddress">User Name</label> <input type="text"
				class="form-control" id="userAddress" name="userAddress"
				placeholder="Enter Address">
		</div>

		<div class="form-group">
			<label for="userAge">User Name</label> <input type="text"
				class="form-control" id="userAge" name="userAge"
				placeholder="Enter Age">
		</div>

		<div class="form-group">
			<label for="userBirthday">User Name</label> <input type="dates"
				class="form-control" id="userBirthday" name="userBirthday"
				placeholder="Enter user Name">
		</div>


		<button type="submit" class="btn btn-primary">Submit</button>
	</form>








</body>
</html>




