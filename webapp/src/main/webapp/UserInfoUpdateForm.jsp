<%@page import="test.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UpdateForm</title>
</head>
<body>
	
		
	
<form action ="/webapp/ControllerServlet?command=update" method="post">
	<table border="1">
		<tr>
				<td><input type="text" name = "id" value ="${userinfo.id}" readonly="readonly" ></td>
				<td><input type="text" name = "pwd" value ="${userinfo.pwd}"></td>
			<th><input type="submit" value="회원수정"/></th>
			<th><input type="button" value="삭제"
				onclick='location.href="UserInfoDeleteServlet?id=${userinfo.id}";'/></th>
			<th><input type="reset" value="취소"
				onclick='location.href="UserInfoListServlet";'/></th>
		</tr>
	</table>
	</form>
</body>
</html> 
<%-- 1, 1.5,mvc
<th colspan="2">
	<input type="submit" value="회원수정"/>
	<input type="button" value="삭제"
	onclick='location.href="UserInfoDeleteServlet?id=<%=userinfo.getId()%>";'/>
	<input type="reset" value="취소"
		onclick='location.href="UserInfoListServlet";'/>
</th> --%>

<%-- 		<c:forEach var="userinfo" items="${userinfo }">
			<tr>
				<th>ID</th>
				<td><input type="text" name="id" value="${  userinfo.id }"/></td>
			</tr>
			<tr>
				<th>PWD</th>
				<td><input type="text" name="pwd" value="${  userinfo.pwd }"/></td>
			</tr>
		</c:forEach> --%>
	<%-- 	2. mvc 프런트 컨트롤러 사용
		<th colspan="2">
			<input type="submit" value="회원수정"/>
			<input type="button" value="삭제" onclick='location href=
			"/webapp/ControllerServlet?command=delete&id=<%=userinfo.getId() %>";'/>
			<input type="reset" value="취소"
				onclik='location.href="/webapp/ControllerServlet?command=list';'/>
		</th> --%>