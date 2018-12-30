<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%!Connection con;
	Statement stmt;
	ResultSet rs;

	String name, id, pw, div, gender;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	id	= (String)session.getAttribute("id");

	String sql = "select * from member where id = '" + id + "'";
	
	try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con		= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "tds", "tds");
	stmt	= con.createStatement();
	rs		= stmt.executeQuery(sql);
	
	while(rs.next()){
		name	= rs.getString("name");
		id		= rs.getString("id");
		pw		= rs.getString("pw");
		div		= rs.getString("division");
		gender	= rs.getString("gender");
	}
	
	HttpSession httpSession = request.getSession();
	httpSession.setAttribute("name", name);
	httpSession.setAttribute("id", id);
	httpSession.setAttribute("pw", pw);
	
// 	response.sendRedirect("loginResult.jsp");
%>

<form action="ModifyOk" method="post">
	이름 : <input type="text" name="name" size="10" value="<%=name%>"><br />
	아이디 : <input type="hidden" name="id" value="<%=id%>"><%=id%><br />
	비밀번호 : <input type="text" name="pw" size="10"><br />
	부서 : <select name="div">
			<option>개발팀</option>
			<option>영업팀</option>
			<option>CS팀</option>
			<option>운영팀</option>
			<option>보안팀</option>
		</select>
	<% if(gender.equals("man")){ %>
	성별구분 : <input type="radio" name="gender" value="man" checked="checked">남 &nbsp; <input type="radio" name="gender" value="woman">여 <br />
	<%}else{ %>
	성별구분 : <input type="radio" name="gender" value="man">남 &nbsp; <input type="radio" name="gender" value="woman" checked="checked">여 <br />
	<%} %>
	<input type="submit" value="정보수정"> <input type="reset" value="취소">
	</form>
	<%
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(rs != null){
				rs.close();
			}
			if(stmt != null){
				stmt.close();
			}
			if(con != null){
				con.close();
			}
			
		}catch(Exception e2){
			e2.printStackTrace();
		}
		
	}
	
	%>
</body>
</html>