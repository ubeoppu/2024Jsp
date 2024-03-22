package com.meta.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meta.dao.BulletinDAO;
import com.meta.dto.BulletinVO;

public class bulletinUpdateAction implements Action {

		@Override
		public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			
			BulletinVO bVo = new BulletinVO();
			
			bVo.setBulletinNum(Integer.parseInt(request.getParameter("bulletinNum")));
			bVo.setName(request.getParameter("name"));
			bVo.setBulletinTitle(request.getParameter("bulletinTitle"));
			bVo.setBulletinContent(request.getParameter("bulletinContent"));
			
			System.out.println("bVo : " + bVo);
			
			BulletinDAO.getInstance().updateBulletin(bVo);
			
			response.sendRedirect("OttServlet?command=BulletinList_View");
		}

	}