<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>save student </title>
<script type="text/javascript">

function submitView()
{
	alert('test');
	document.getElementById("frm").action="ViewStudentController";
	document.getElementById("frm").submit();
	alert('test');
	}
</script>
</head>
<body>
<form id="frm" action="StudentControler" method="post" autocomplete="on" id="frm">

    <c:out value="${option}"/>
<br>
Name:<input type="text" name="name"/><br>
Age:<input type="text" name="age"/><br>
mobile:<input type="text" name="mobile"/><br>
<input type="submit" value="Save"/>
<br>
  <input type="button" value="View All" onclick="submitView()">  

</form>

</body>
</html>