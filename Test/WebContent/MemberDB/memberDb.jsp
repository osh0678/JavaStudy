<%@page import="org.apache.jasper.tagplugins.jstl.core.Catch"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%!Connection con;
	Statement stmt;
	ResultSet rs;

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@211.238.138.200:1521:teststd";
	String uid = "tds";
	String upw = "tds";
	String query = "select * from MNG_ACCOUNT";%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%

	try{
	Class.forName(driver);
	con = DriverManager.getConnection(url, uid, upw);
	stmt = con.createStatement();
	rs = stmt.executeQuery(query);
	
	while(rs.next()){
		String id = rs.getString(1);
		String name = rs.getString(3);
		String position = rs.getString(4);
		String div = rs.getString(5);
		
		out.println("아이디 : "	+ id);
		out.println(" 이름 : "		+ name);
		out.println(" 직책 : "		+ position );
		out.println(" 부서 : "	+ div + "<br />");
		
	}
		
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