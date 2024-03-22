package com.meta.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meta.dao.CommentDAO;

public class commentUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		
		int commentNum =Integer.parseInt(request.getParameter("commentNum"));
		
		String commentContent = request.getParameter("commentContent");
		
		CommentDAO cDao = CommentDAO.getInstance();
		
		int result = cDao.updateComment(commentNum, commentContent);
		
		System.out.println("RESULT>>!" + result);
		
		request.getRequestDispatcher("project/close.jsp").forward(request, response);
		

	}

}
