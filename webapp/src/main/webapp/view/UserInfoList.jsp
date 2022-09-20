<%@page import="test.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ page import ="java.util.*" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
</head>
<body>
<div>
	  <%-- <% test.User data = (test.User)request.getAttribute("data");%>  --%>
	  <%-- <% ArrayList<User> data = (ArrayList<User>)request.getAttribute("data");%> --%>
	<table border='1'>
	 <c:forEach var="data" items="${data}">
	 	<tr><td onClick="location.href='http://www.daum.net'" style="cursor:pointer;"><b>${data.id}</b></td>
	 	<td><b>${data.pwd}</b></td>
	 	<td><b><button type="button" onClick="location.href='http://www.daum.net'" style="cursor:pointer;">Delete</button></b></td>
	 	</tr>
	</c:forEach> 
	</table>
		<button type="button" onClick="location.href='view/Join.jsp'" style="cursor:pointer; margin: auto; width : 80px;">Join</button>
		<button type="button" onClick="location.href='view/Login.jsp'" style="cursor:pointer; margin: 15px; width : 80px;">Login</button>
</div>
</body>
</html>