<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%!
	String id,pw;
%>

<%
	id = request.getParameter("id");
	pw = request.getParameter("pw");
%>

	<h1>foword_param 입니다.</h1>
	아이디 : <%= id %>
	비밀번호 : <%= pw %>
</body>
</html>