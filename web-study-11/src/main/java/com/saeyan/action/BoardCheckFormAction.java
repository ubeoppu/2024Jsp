package com.saeyan.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardCheckFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String num = request.getParameter("num");
		
		request.setAttribute("num", num);
		
		request.getRequestDispatcher("board/boardCheckPass.jsp").forward(request, response);
		
		
		
	}

}
