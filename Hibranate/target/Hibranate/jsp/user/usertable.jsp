<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>



</head>
<body>


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





</body>
</html>





