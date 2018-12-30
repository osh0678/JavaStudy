package com.javalec.ex;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class ModifyOk
 */
@WebServlet("/ModifyOk")
public class ModifyOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Connection con;
	private Statement stmt;
	
	private String name, id ,pw, div, gender;
	
	HttpSession httpSession;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyOk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("EUC-KR");
		httpSession = request.getSession();
		
		name	= request.getParameter("name");
		id		= request.getParameter("id");
		pw		= request.getParameter("pw");
		div		= request.getParameter("div");
		gender	= request.getParameter("gender");
		
		if(pwConfirm()) {
			System.out.println("OK");
			
			String sql = "update member set name = '" + name +"', division ='" + div +"', gender ='" + gender + "' where id = '" + id + "'";
			
			try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "tds", "tds");
			stmt = con.createStatement();
			int i = stmt.executeUpdate(sql);
			
			System.out.println(sql);
			System.out.println(i);
			if(i == 1) {
				System.out.println("update success");
				httpSession.setAttribute("name", name);
				response.sendRedirect("modifyResult.jsp");
			}else {
				System.out.println("update failed");
				response.sendRedirect("modify.jsp");
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				try {
					if(stmt != null) {
						stmt.close();
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}else {
			System.out.println("NG");
		}
	}
	private boolean pwConfirm() {
		boolean rs = false;
		
		String sessionPw = (String)httpSession.getAttribute("pw");
		
		if(sessionPw.equals(pw)) {
			rs = true;
		}else {
			rs = false;
		}
		return rs;
	}

}
