<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<!-- 비로그인 상태 -->
	<% if(session.getAttribute("login") == null || !(boolean)session.getAttribute("login")){ %>
	<Strong>로그인이 필요합니다</Strong>
	<button onclick='location.href="/login";'>Login</button>
	<button onclick='location.href="/join";'>Join</button>

	<!-- 로그인 상태 -->
	<%} else if((boolean)session.getAttribute("login")){ %>
	<Strong>${name}님 환영합니다.</Strong><br>
	
</div>
</body>
</html>