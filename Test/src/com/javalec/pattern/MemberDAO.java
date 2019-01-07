package com.javalec.pattern;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDAO {
	
//	public static final int MEMBER_NONEXISTENT = 0;
//	public static final int MEMBER_EXISTENT = 1;
//	public static final int MEMBER_JOIN_FAIL = 0;
//	public static final int MEMBER_JOIN_SUCCESS = 1;
//	public static final int MEMBER_LOGIN_PW_NO_GOOD = 0;
//	public static final int MEMBER_LOGIN_SUCCESS = 1;
//	public static final int MEMBER_LOGIN_IS_NOT = -1;
	
	private static MemberDAO instance = new MemberDAO();

	private MemberDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public int insertMember(MemberDTO dto) {
		int ri = 0;
		
		Connection con			= null;
		PreparedStatement pstmt	= null;
		String sql				= "insert into members values (?,?,?,?,?,?)";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			System.out.println(pstmt);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.geteMail());
			pstmt.setTimestamp(5, dto.getrDate());
			pstmt.setString(6, dto.getAddress());
			pstmt.executeUpdate();
			
			ri = 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return ri;
	}
	
	public int confirmId(String id) {
		int ri = 0;
		
		Connection con			= null;
		PreparedStatement pstmt	= null;
		ResultSet rs			= null;
		String sql				= "select * from members where id = ?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				ri = 1;
			}else {
				ri = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return ri;
	}
	
	public int userCheck(String id, String pw) {
		int ri = 0;
		String dbPw;
		
		Connection con			= null;
		PreparedStatement pstmt	= null;
		ResultSet rs			= null;
		String sql				= "select pw from members where id = ?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbPw = rs.getString("PW");
				if(dbPw.equals(pw)) {
					ri = 1;
				}else {
					ri = 0;
				}
			}else {
				ri = -1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return ri;
	}
	
	public MemberDTO getMember(String id) {
		Connection con			= null;
		PreparedStatement pstmt	= null;
		ResultSet rs			= null;
		String sql				= "select * from members where id = ?";
		MemberDTO dto			= null;
		
		try {
			con	= getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs	= pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setId(rs.getString("ID"));
				dto.setPw(rs.getString("PW"));
				dto.setName(rs.getString("NAME"));
				dto.seteMail(rs.getString("MAIL"));
				dto.setrDate(rs.getTimestamp("RDATE"));
				dto.setAddress(rs.getString("ADDRESS"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return dto;
	}
	
	public int updateMember(MemberDTO dto) {
		int ri = 0;
		Connection con			= null;
		PreparedStatement pstmt	= null;
		String sql				= "update members set pw =?, mail = ?, address=? where id = ?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.geteMail());
			pstmt.setString(3, dto.getAddress());
			pstmt.setString(4, dto.getId());
			
			ri = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return ri;
	}
	
	public ArrayList<MemberDTO> membersAll(){
		
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from MEMBERS";
		
		System.out.println("membersAll »£√‚");
		
		try {
			System.out.println("DB connection");
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			System.out.println("==============");
			
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.seteMail(rs.getString("mail"));
				dto.setrDate(rs.getTimestamp("rdate"));
				dto.setAddress(rs.getString("address"));
				dtos.add(dto);
			}
			
			System.out.println("==============");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		System.out.println(dtos);
		return dtos;
	}
	
	private Connection getConnection() {
		Context context = null;
		DataSource dataSource = null;
		Connection con = null;
		
		try {
			context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			con = dataSource.getConnection();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return con;
	}
}
