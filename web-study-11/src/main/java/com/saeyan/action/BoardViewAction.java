package com.saeyan.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardViewAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardVO vo = new BoardVO();
		BoardDAO bDao = BoardDAO.getInstance();
		vo = bDao.selectOneBoardByNum(num);
		
		System.out.println("vo>>"+ vo);
		
		
		
		request.setAttribute("board", vo);
		
		request.getRequestDispatcher("board/boardView.jsp").forward(request, response);
		
		
	}
	

}
