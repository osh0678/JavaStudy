package com.javalec.board.ex.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.board.ex.dao.BDAO;
import com.javalec.board.ex.dto.BDTO;

public class BListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println("list ¿‘¥œ¥Ÿ.");

		BDAO dao = new BDAO();
		ArrayList<BDTO> dtos = dao.list();
		request.setAttribute("list", dtos);
	}

}
