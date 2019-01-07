package com.javalec.pattern;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Service{
	public ArrayList<MemberDTO> execute(HttpServletRequest request, HttpServletResponse response);
}
