package com.saeyan.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardCheckPassAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int num =  Integer.parseInt(request.getParameter("num"));
		String pass = request.getParameter("pass");
		
		String url = null;
		
		BoardDAO bDao = BoardDAO.getInstance();
		
		BoardVO vo = bDao.checkPassword(pass, num);
		
		if(pass.equals(vo.getPass())) {
			url ="/board/checkSuccess.jsp";
		}else{
			url = "/board/boardCheckPass.jsp";
			request.setAttribute("message", "로그인 실패하였습니다.");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	

}
