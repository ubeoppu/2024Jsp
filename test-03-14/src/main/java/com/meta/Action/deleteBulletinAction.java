package com.meta.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meta.dao.BulletinDAO;

public class deleteBulletinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num =Integer.parseInt(request.getParameter("bulletinNum"));
		
		BulletinDAO.getInstance().deleteBulletin(num);
		
		response.sendRedirect("OttServlet?command=BulletinList_View");

	}

}
