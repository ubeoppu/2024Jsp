package com.meta.Action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meta.dao.BulletinDAO;
import com.meta.dto.BulletinVO;

public class selectBulletinContentViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		BulletinVO vo = new BulletinVO();
		
		
		int num =Integer.parseInt(request.getParameter("bulletinNum"));
		
		vo =BulletinDAO.getInstance().selectOneBulletin(num);
		
	    request.setAttribute("bulletin", vo);
		
	    request.getRequestDispatcher("project/selectBulletinView.jsp").forward(request, response);
		
//		String vo = new BulletinVO();
		
//		vo.setBulletinNum(0);
//		vo.setBulletinTitle(null);
//		vo.setName(null);
//		vo.setBulletinDate(null);
//		vo.setBulletinContent(null);
//		
//		
//		
		 
		 
		

	}

}
