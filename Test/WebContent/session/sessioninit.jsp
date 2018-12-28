<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	session.setAttribute("myNum", 1234567891);
	session.setAttribute("mySessionName", "mySessionData");
	

%>

<a href="sessionget.jsp">session get</a>
</body>
</html>