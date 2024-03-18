package com.saeyan.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardUpdateFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		BoardDAO bDao = BoardDAO.getInstance();
		BoardVO vo = new BoardVO();
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		vo = bDao.selectOneBoardByNum(num);
		
		bDao.updateReadCount(num);
		
		request.setAttribute("board", vo);
		
		request.getRequestDispatcher("board/boardUpdate.jsp")
		.forward(request, response);
		
		
		
		
	}

}
