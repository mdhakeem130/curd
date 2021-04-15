<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>!--%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Student Form</title>
</head>
<body>

<form id="frm" action="UpdateStudentController" method="post" autocomplete="on" id="frm">

    <c:out value="${option}"/>
    <br>
Name:<input type="text" name="name" value="<c:out value="${beam.name}"></c:out>"/><br>
Age:<input type="text" name="age" value="<c:out value="${beam.age}"></c:out>"/><br>
mobile:<input type="text" name="mobile" value="<c:out value="${beam.mobile}"></c:out>"/><br>
<input type="hidden" name="id" value="<c:out value="${beam.id}"></c:out>"/><br>
<input type="submit" value="Save"/>
<br>
</form>

</body>
</html>