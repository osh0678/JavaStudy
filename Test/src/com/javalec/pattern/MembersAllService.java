package com.javalec.pattern;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MembersAllService implements Service {

	public MembersAllService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ArrayList<MemberDTO> execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		MemberDAO dao = MemberDAO.getInstance();
		return dao.membersAll();
	}
}
