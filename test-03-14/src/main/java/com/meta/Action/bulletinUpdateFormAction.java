package com.meta.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meta.dao.BulletinDAO;
import com.meta.dto.BulletinVO;

public class bulletinUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bulletinNum = Integer.parseInt(request.getParameter("bulletinNum"));
		
		BulletinVO vo = new BulletinVO();
		
		vo = BulletinDAO.getInstance().selectOneBulletin(bulletinNum);
		
		request.setAttribute("bulletin", vo);
		
		request.getRequestDispatcher("project/bulletinUpdate.jsp").forward(request, response);

	}

}
