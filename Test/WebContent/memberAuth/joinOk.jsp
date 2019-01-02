<%@page import="com.javalec.member.MemberDAO"%>
<%@ page import="java.sql.Timestamp" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("EUC-KR"); %>
<jsp:useBean id="dto" class="com.javalec.member.MemberDTO"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	dto.setrDate(new Timestamp(System.currentTimeMillis()));
	MemberDAO dao = MemberDAO.getInstance();
	if(dao.confirmId(dto.getId()) == MemberDAO.MEMBER_EXISTENT){
%>
	<script type="text/javascript">
		alert('���̵� �̹� �����մϴ�.');
		history.back();
	</script>
<%
	}else{
		int ri = dao.insertMember(dto);
		if(ri == MemberDAO.MEMBER_JOIN_SUCCESS){
			session.setAttribute("id", dto.getId());
%>
			<script type="text/javascript">
				alert('ȸ�������� �����մϴ�.');
				document.location.href='login.jsp';
			</script>
<%
		}else{
%>
			<script type="text/javascript">
				alert('ȸ�����Կ� �����߽��ϴ�.');
				document.location.href='login.jsp';
			</script>
<%
		}
	}
%>
</body>
</html>