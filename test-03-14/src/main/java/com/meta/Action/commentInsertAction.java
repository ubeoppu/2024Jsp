package com.meta.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meta.dao.CommentDAO;

public class commentInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("왜 안찍혀 ;;");
		HttpSession session = request.getSession();
		
		String commentContent =request.getParameter("commentContent");
		int bulletinNum = Integer.parseInt(request.getParameter("bulletinNum"));
		String userid = (String)session.getAttribute("userid");
		
		System.out.println("댓글내용"+commentContent);
		System.out.println("게시글번호"+bulletinNum);
		System.out.println("유저아이디"+userid);
		
		CommentDAO.getInstance().insertComment(bulletinNum, commentContent, userid);
		
		response.sendRedirect("OttServlet?command=bulletin_content_View&bulletinNum="+ bulletinNum+"");
	
		

	}

}
