<%@page import="test.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ page import ="java.util.*" %>
<%-- <a href='/webapp/ControllerServlet?command=update_form&id=<%=userInfo.getId()%>'></a> 업데이트 폼 이동
<a href='/webapp/ControllerServlet?command=delete&id=<%=userInfo.getId()%>'></a> 삭제 이동--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
</head>
<body>
<form action ="Join.jsp" method="post">
<div>

	<table border='1'>
	 <c:forEach var="userInfo" items="${userInfo}">
	 	<tr><td style="cursor:pointer;"><b><a href='/webapp/userinfo/updateform.do?id=${userInfo.id}'>${userInfo.id}</a></b></td>
	 	<td><b>${userInfo.pwd}</b></td>
	 	<td><b><a href='/webapp/userinfo/delete.do?id=${userInfo.id}'>Delete</a></b></td>
	 	
	 	</tr>
	</c:forEach> 
	</table>

		<input type="submit" value ="Join"style="cursor:pointer; margin: auto; width : 80px;">
</div>
</form>
</body>
</html>
