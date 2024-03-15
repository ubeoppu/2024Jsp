package com.saeyan.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardReadCountAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		BoardVO vo = new BoardVO();
		BoardDAO bDao = BoardDAO.getInstance();
		int num = Integer.parseInt(request.getParameter("num"));
		bDao.updateReadCount(num);
		
		vo = bDao.selectOneBoardByNum(num);
		
		request.setAttribute("board", vo);
		
		request.getRequestDispatcher("board/boardView.jsp")
		.forward(request, response);
		
	}
	

}
