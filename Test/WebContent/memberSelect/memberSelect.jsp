<%@page import="com.javalec.ex.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.javalec.ex.MemberDAO"%>
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
	MemberDAO memberDAO = new MemberDAO();
	ArrayList<MemberDTO> dtos = memberDAO.memberSelect();
	
	for(int i = 0; i < dtos.size(); i++){
		MemberDTO dto = dtos.get(i);
		String name	= dto.getName();
		String id	= dto.getId();
		String pw	= dto.getPw().substring(0,5);
		String div	= dto.getDiv();
		String pos	= dto.getPos();
		
		out.println("�̸� : " + name + ", ���̵� : " + id + ", ��й�ȣ : " + pw + ", �μ� : " + div + ", ���� : " + pos + "<br />");		
	
	}

%>
</body>
</html>