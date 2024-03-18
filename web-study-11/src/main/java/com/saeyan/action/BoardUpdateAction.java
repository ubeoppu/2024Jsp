package com.saeyan.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8"); //읽어올게있으면 작성
		response.setContentType("text/html; charset=utf-8"); //저장할거면 작성해라
		
		BoardDAO bDao = BoardDAO.getInstance();
		BoardVO vo = new BoardVO();
		
		
		vo.setName(request.getParameter("name"));
		vo.setPass(request.getParameter("pass"));
		vo.setEmail(request.getParameter("email"));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		System.out.println("vo>>" + vo);
		int result = bDao.updateBoard(vo);
		
		System.out.println("result>>" + result);
		response.sendRedirect("BoardServlet?command=board_list");
		
//		request.getRequestDispatcher("BoardServlet?command=board_list").forward(request, response);
	}

}
