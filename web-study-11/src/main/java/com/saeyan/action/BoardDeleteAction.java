package com.saeyan.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;

public class BoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int num =Integer.parseInt(request.getParameter("num"));
		
		BoardDAO.getInstance().deleteBoard(num);
		
		response.sendRedirect("BoardServlet?command=board_list");

	}

}
