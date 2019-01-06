package com.javalec.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDAO {

	private String url = "jdbc:oracle:thin:@211.238.138.200:1521:teststd";
	private String uid = "tds";
	private String upw = "tds";
	
	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
			
	
	public ArrayList<MemberDTO> memberSelect(){
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		
		Connection con	= null;
		Statement stmt	= null;
		ResultSet rs	= null;
		
		try {
			con		= DriverManager.getConnection(url, uid, upw);
			stmt	= con.createStatement();
			rs		= stmt.executeQuery("select * from MNG_ACCOUNT");
			
			while (rs.next()) {
				String name		= rs.getString("NAME");
				String id		= rs.getString("USER_N");
				String pw		= rs.getString("PASSWD");
				String div		= rs.getString("DIVISION");
				String pos		= rs.getString("POSITION");
				
				MemberDTO dto = new MemberDTO(name, id, pw, div, pos);
				dtos.add(dto);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(con != null) {
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}
}
