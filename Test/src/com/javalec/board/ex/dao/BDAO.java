package com.javalec.board.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.board.ex.dto.BDTO;

public class BDAO {

	DataSource dataSource;
	
	public BDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void write(String bName, String bTitle, String bContent) {
		Connection con			= null;
		PreparedStatement pstmt	= null;

		try {
			con = dataSource.getConnection();
			String sql = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0 )";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3,bContent);
			
			int rn = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public ArrayList<BDTO> list(){
		ArrayList<BDTO> dtos 	= new ArrayList<BDTO>();
		Connection con			= null;
		PreparedStatement pstmt	= null;
		ResultSet rs			= null;
		
		try {
			con = dataSource.getConnection();
			
			String sql = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from mvc_board order by bGroup desc, bStep asc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int bId			= rs.getInt("bId");
				String bName	= rs.getString("bName");
				String bTitle	= rs.getString("bTitle");
				String bContent	= rs.getString("bContent");
				Timestamp bDate	= rs.getTimestamp("bDate");
				int bHit		= rs.getInt("bHit");
				int bGroup		= rs.getInt("bGroup");
				int bStep		= rs.getInt("bStep");
				int bIndent		= rs.getInt("bIndent");
				
				BDTO dto = new BDTO(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return dtos;
	}
	
	public BDTO contentView(String strID) {
		upHit(strID);
		
		BDTO dto = null;
		Connection con			= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		
		try {
			con = dataSource.getConnection();
			
			String sql = "select * from mvc_board where bId = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(strID));
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int bId			= rs.getInt("bId");
				String bName	= rs.getString("bName");
				String bTitle	= rs.getString("bTitle");
				String bContent	= rs.getString("bContent");
				Timestamp bDate	= rs.getTimestamp("bDate");
				int bHit		= rs.getInt("bHit");
				int bGroup		= rs.getInt("bGroup");
				int bStep		= rs.getInt("bStep");
				int bIndent		= rs.getInt("bIndent");
				
				dto = new BDTO(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return dto;
	}
	
	public void modify(String bId, String bName, String bTitle, String bContent) {
		Connection con			= null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();

			String sql = "update mvc_board set bName = ?, bTitle = ?, bContent = ? where bId = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, Integer.parseInt(bId));
			int rn = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
	}
	
	public void delete(String bId) {
		Connection con			= null;
		PreparedStatement pstmt = null;
		try {
			
			con = dataSource.getConnection();
			String sql = "delete from mvc_board where bId = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(bId));
			int rn = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	public BDTO reply_view(String str) {
		// TODO Auto-generated method stub
		BDTO dto = null;
		
		Connection con			= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		try {
			
			con = dataSource.getConnection();
			String sql = "select * from mvc_board where bId = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(str));
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int bId 		= rs.getInt("bId");
				String bName	= rs.getString("bName");
				String bTitle 	= rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit 		= rs.getInt("bHit");
				int bGroup 		= rs.getInt("bGroup");
				int bStep 		= rs.getInt("bStep");
				int bIndent		= rs.getInt("bIndent");
				
				dto = new BDTO(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return dto;
	}
	
	public void reply(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep, String bIndent) {
		// TODO Auto-generated method stub
		
		replyShape(bGroup, bStep);
		
		Connection con			= null;
		PreparedStatement pstmt = null;
		
		
		try {
			con = dataSource.getConnection();
			String sql = "insert into mvc_board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, Integer.parseInt(bGroup));
			pstmt.setInt(5, Integer.parseInt(bStep) + 1);
			pstmt.setInt(6, Integer.parseInt(bIndent) + 1);
			
			int rn = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
	}
	
	private void replyShape( String strGroup, String strStep) {
		// TODO Auto-generated method stub
		Connection con			= null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "update mvc_board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(strGroup));
			pstmt.setInt(2, Integer.parseInt(strStep));
			
			int rn = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	private void upHit(String bId) {
		Connection con			= null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "update mvc_board set bHit = bHit + 1 where bId = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(bId));
			
			int rn = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
				
	}
}
