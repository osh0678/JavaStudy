<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="member" class="com.javalec.ex.MemberInfo" scope="page"></jsp:useBean>
<jsp:setProperty property="user" name="member" value="홍길동"/>
<jsp:setProperty property="id" name="member" value="abc"/>
<jsp:setProperty property="pw" name="member" value="123"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	이름  : <jsp:getProperty name="member" property="id"/><br />
	아이디 : <jsp:getProperty name="member" property="user"/><br />
	비밀번호 : <jsp:getProperty name="member" property="pw"/><br />
	
	<hr />
	
	이름 : ${member.user}<br />
	아이디 : ${member.id}<br />
	비밀번호 : ${member.pw}<br />
</body>
</html>