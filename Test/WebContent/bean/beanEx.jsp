<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<jsp:useBean id="student" class="com.javalec.ex.Student" scope="page" />
<%-- * Scope = ���� ����
	page		: ������ ������ �������� ��� ���� 
	request		: ��û�� ������ �������� ��� ����
	session		: ���������� �����ֱ�� �����ϰ� ��� ����
	application	: �� ���ø����̼� �����ֱ�� �����ϰ� ��밡��
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<jsp:setProperty property="name" name="student" value="ȫ�浿" />
	<jsp:setProperty property="age" name="student" value="13" />
	<jsp:setProperty property="grade" name="student" value="6" />
	<jsp:setProperty property="studentNum" name="student" value="7" />

	�̸� : <jsp:getProperty property="name" name="student" /><br />
	���� : <jsp:getProperty property="age" name="student" /><br /> 
	�г� : <jsp:getProperty property="grade" name="student" /><br /> 
	��ȣ : <jsp:getProperty property="studentNum" name="student" /><br />


</body>
</html>