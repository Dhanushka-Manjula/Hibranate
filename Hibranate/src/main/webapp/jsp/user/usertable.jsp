<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ page import="java.util.List" %>
         <%@ page import="com.company.model.*" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>

<jsp:include page="../common/externalfiles.jsp"></jsp:include>

</head>
<body>

<jsp:include page="../common/header.jsp"></jsp:include>

<a href="new1">Add New Book</a>
  Hello <c:out value="${name}"/>! JSTL Welcomes you!!

<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Books</h2></caption>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>

<%

 List<User> list = (List)request.getAttribute("userList");

for(User user : list){
	
	out.print("<tr>"+
				" <td>"+user.getId() +"</td>"+
				" <td>"+user.getName() +"</td>"+
				" <td>"+user.getAddress() +"</td>"+
				" <td>"+user.getAge() +"</td>"+
				" <td>"+
				"         <a href='/edit?id="+user.getId() +"'>Edit</a>"

				
				+"</td>"+
				"</tr>"
			);
	
}



%>
            <c:forEach var="user" items="${requestScope.userList}">
                <tr>
                    <td><c:out value="${user}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.address}" /></td>
                    <td><c:out value="${user.age}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${user.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${user.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   



<jsp:include page="../common/footer.jsp"></jsp:include>

</body>
</html>





