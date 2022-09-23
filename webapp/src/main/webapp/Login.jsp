<%@page import="test.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login System</title>
</head>
<body>
<!-- 컨트롤러서블릿 -->
	<form action ="/webapp/userinfo/list.do" method="post">
	<div>
		
		Login System <p/>
		<input type="text" name="id" size="10" placeholder="ID input"><p/>
		<input type="text" name="pwd" size="10" placeholder="PWD input"><p/>
		<input type="text" name="pwdcheck" size="10" placeholder="PWD check">	<p/>
		
		<input type="submit" value ="Login">
		<button type="button" onclick="location.href='Join.jsp' ">Join</button>
	</div>
	</form>
</body>
</html>
