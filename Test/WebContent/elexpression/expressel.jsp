<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="member" class="com.javalec.ex.MemberInfo" scope="page"></jsp:useBean>
<jsp:setProperty property="user" name="member" value="ȫ�浿"/>
<jsp:setProperty property="id" name="member" value="abc"/>
<jsp:setProperty property="pw" name="member" value="123"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	�̸�  : <jsp:getProperty name="member" property="id"/><br />
	���̵� : <jsp:getProperty name="member" property="user"/><br />
	��й�ȣ : <jsp:getProperty name="member" property="pw"/><br />
	
	<hr />
	
	�̸� : ${member.user}<br />
	���̵� : ${member.id}<br />
	��й�ȣ : ${member.pw}<br />
</body>
</html>