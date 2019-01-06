package com.javalec.board.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.board.ex.dao.BDAO;
import com.javalec.board.ex.dto.BDTO;


public class BContentCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String bld	= request.getParameter("bld");
		BDAO dao = new BDAO();
		BDTO dto = new BDTO();
		
		request.setAttribute("content_view", dto);
		

	}

}
