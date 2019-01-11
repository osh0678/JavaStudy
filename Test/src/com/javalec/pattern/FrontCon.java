package com.javalec.pattern;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontCon
 */
@WebServlet("*.dos")
public class FrontCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontCon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		actionDo(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		System.out.println(command);
		if(command.equals("/membersAll.do")) {
			response.setContentType("text/html; charset=EUC-KR");
			PrintWriter writer = response.getWriter();
			writer.println("<html><head></head><body>");
			
			Service service = new MembersAllService();
			ArrayList<MemberDTO> dtos = service.execute(request, response);
			System.out.println("service : " + service + " dtos : " +  dtos + " size :" + dtos.size());

			for(int i = 0; i < dtos.size() ; i++) {
				System.out.println("for ¹®");
				MemberDTO dto	= dtos.get(i);
				String id		= dto.getId();
				String pw		= dto.getPw();
				String name		= dto.getName();
				String eMail	= dto.geteMail();
				Timestamp rDate	= dto.getrDate();
				String address	= dto.getAddress();
				
				writer.println(id + ", " + pw + ", " + name + ", " + eMail + ", " + rDate.toLocalDateTime() + ", " + address + "<hr />");
			}
			
			writer.println("</body></html>");
		}
//		else if(command.equals("/insert.do")) {
//			System.out.println("insert");
//			System.out.println("---------------");
//		}else if (command.equals("/update.do")) {
//			System.out.println("update");
//			System.out.println("---------------");
//		}else if (command.equals("/select.do")) {
//			System.out.println("select");
//			System.out.println("---------------");
//		}else if (command.equals("/delete.do")) {
//			System.out.println("delete");
//			System.out.println("---------------");
//		}
	}
}
