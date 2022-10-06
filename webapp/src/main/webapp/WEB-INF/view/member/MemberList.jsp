
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>>Member List</title>
</head>
<body>
	<table border='1'>
	 <c:forEach var="members" items="${members}">
	 	<tr><td style="cursor:pointer;"><b><a href='/webapp/updateform?email=${members.email}'>${members.email}</a></b></td>
	 	<td><b>${members.pwd}</b></td>
	 	<td><b><a href='/webapp/delete.?email=${members.email}'>Delete</a></b></td>
	 	
	 	</tr>
	</c:forEach> 
	</table>
</body>
</html>