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
	�̸� : <input type="text" name="name" size="10" value="<%=name%>"><br />
	���̵� : <input type="hidden" name="id" value="<%=id%>"><%=id%><br />
	��й�ȣ : <input type="text" name="pw" size="10"><br />
	�μ� : <select name="div">
			<option>������</option>
			<option>������</option>
			<option>CS��</option>
			<option>���</option>
			<option>������</option>
		</select>
	<% if(gender.equals("man")){ %>
	�������� : <input type="radio" name="gender" value="man" checked="checked">�� &nbsp; <input type="radio" name="gender" value="woman">�� <br />
	<%}else{ %>
	�������� : <input type="radio" name="gender" value="man">�� &nbsp; <input type="radio" name="gender" value="woman" checked="checked">�� <br />
	<%} %>
	<input type="submit" value="��������"> <input type="reset" value="���">
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