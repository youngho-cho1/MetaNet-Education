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
	<table border='1'>
	 <c:forEach var="userinfos" items="${userinfos}">
	 	<tr><td onClick="location.href='http://www.daum.net'" style="cursor:pointer;"><b>${userinfos.id}</b></td>
	 	<td><b>${userinfos.pwd}</b></td>
	 	<td><b><button type="button" onClick="location.href='http://www.daum.net'" style="cursor:pointer;">Delete</button></b></td>
	 	</tr>
	</c:forEach> 
	</table>
		<button type="button" onClick="location.href='UserInfoAddServlet'" style="cursor:pointer; margin: auto; width : 80px;">Join</button>
		<button type="button" onClick="location.href='view/Login.jsp'" style="cursor:pointer; margin: 15px; width : 80px;">Login</button>
		<%-- <jsp:include page="..jsp"/> --%>
</div>
</body>
</html>