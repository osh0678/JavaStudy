<%@ page import="com.javalec.member.MemberDAO" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("EUC-KR"); %>

<jsp:useBean id="dto" class="com.javalec.member.MemberDTO" scope="page"></jsp:useBean>
<<jsp:setProperty property="*" name="dto"/>
<%
	String id = (String)session.getAttribute("id");
	dto.setId(id);
	
	MemberDAO dao = MemberDAO.getInstance();
	int ri = dao.updateMember(dto);
	
	if(ri == 1){
%>
	<script>
		alert('���� �����Ǿ����ϴ�.');
		document.location.href="main.jsp";
	</script>
<%
	}else{
%>
	<script>
		alert('���� ���� �����Դϴ�.');
		history.go(-1);
	</script>
<%}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>