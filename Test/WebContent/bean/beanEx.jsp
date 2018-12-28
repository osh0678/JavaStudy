<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<jsp:useBean id="student" class="com.javalec.ex.Student" scope="page" />
<%-- * Scope = 범위 지정
	page		: 생성된 페이지 내에서만 사용 가능 
	request		: 요청된 페이지 내에서만 사용 가능
	session		: 웹브라우저의 생명주기와 동일하게 사용 가능
	application	: 웹 어플리케이션 생명주기와 동일하게 사용가능
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<jsp:setProperty property="name" name="student" value="홍길동" />
	<jsp:setProperty property="age" name="student" value="13" />
	<jsp:setProperty property="grade" name="student" value="6" />
	<jsp:setProperty property="studentNum" name="student" value="7" />

	이름 : <jsp:getProperty property="name" name="student" /><br />
	나이 : <jsp:getProperty property="age" name="student" /><br /> 
	학년 : <jsp:getProperty property="grade" name="student" /><br /> 
	번호 : <jsp:getProperty property="studentNum" name="student" /><br />


</body>
</html>