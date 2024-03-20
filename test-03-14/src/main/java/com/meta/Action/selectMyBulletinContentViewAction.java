package com.meta.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meta.dao.BulletinDAO;
import com.meta.dto.BulletinVO;

public class selectMyBulletinContentViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	BulletinVO vo = new BulletinVO();
		
		
		int num =Integer.parseInt(request.getParameter("bulletinNum"));
		
		vo =BulletinDAO.getInstance().selectOneBulletin(num);
		
	    request.setAttribute("bulletin", vo);
		
	    request.getRequestDispatcher("project/selectBulletinView.jsp").forward(request, response);
	}

}
