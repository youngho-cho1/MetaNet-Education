<%@page import="test.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join System</title>
</head>
<body>
 		 <% test.User data = (test.User)request.getAttribute("data");%>
	<div>
		Join System <p/>
		<input type="text" name="id" size="10" placeholder="ID input"><p/>
		<input type="password" name="pwd" size="10" placeholder="PWD input"><p/>
		<input type="password" name="pwdcheck" size="10" placeholder="PWD check">	<p/>
		
		<button type="button" onClick="location.href='./UserInfoAddServlet'" style="cursor:pointer; margin: auto; width : 80px;">Commit</button>
		<button type="button" onClick="location.href='view/UserInfoList.jsp'" style="cursor:pointer; margin: 15px; width : 80px;">Back</button>
	</div>
</body>
</html>