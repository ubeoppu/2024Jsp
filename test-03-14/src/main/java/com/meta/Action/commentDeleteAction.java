package com.meta.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meta.dao.CommentDAO;

public class commentDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("댓글삭제 테스트화면");
		int commentNum =Integer.parseInt(request.getParameter("commentNum"));
		int bulletinNum = Integer.parseInt(request.getParameter("bulletinNum"));
		System.out.println("bulletin번호에용>" +bulletinNum);
		
		
		System.out.println("댓글번호에요" + commentNum);
		CommentDAO.getInstance().deleteComment(commentNum);
		response.sendRedirect("OttServlet?command=bulletin_content_View&bulletinNum="+ bulletinNum +"");
	}

}
//+ bulletinNum +""