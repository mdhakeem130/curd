<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>view all Student </title>
</head>
<body>

<c:out value="${updateflage}"></c:out>
<c:out value="${updateflage}"></c:out>

<table border="1">

<tr>
<td>ID</td>
<td>Name</td>
<td>Mobile</td>
<td>Age</td>
<td>Edit</td>
<td>Delete</td>
</tr>

<c:forEach var="std" items="${details }">


<tr>
<td>  <c:out value="${std.id }"></c:out>   </td>
<td>  <c:out value="${std.name }"></c:out>  </td>
<td>  <c:out value="${std.age }"></c:out>  </td>
<td>  <c:out value="${std.mobile }"></c:out> </td>
<td>  <a href="StudentEditController?id=<c:out value="${std.id}"/>">Edit</a> </td>
<td>  <a href="StudentDeleteController?id=<c:out value="${std.id}"/>">Delete</a> </td>

</tr>

</c:forEach>


</table>
</body>
</html>