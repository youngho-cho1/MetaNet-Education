<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h2>사용자 로그인</h2>
	<form action="login" method="post">
		이메일: <input type="text" name="email"><br>
		암호: <input type="password" name="pwd"><br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>