package com.javalec.board.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.board.ex.dao.BDAO;

public class BWriteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		BDAO dao = new BDAO();
		System.out.println(bName + "\t" + bTitle + "\t" + bContent);
		dao.write(bName, bTitle, bContent);

	}

}
