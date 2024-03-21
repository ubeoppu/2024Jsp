package com.meta.Action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meta.dao.BulletinDAO;
import com.meta.dao.CommentDAO;
import com.meta.dto.BulletinVO;
import com.meta.dto.CommentVO;

public class selectBulletinContentViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		BulletinVO vo = new BulletinVO();
		
		
		int num =Integer.parseInt(request.getParameter("bulletinNum"));
		
		vo =BulletinDAO.getInstance().selectOneBulletin(num);
		
		request.setAttribute("bulletinNum", vo.getBulletinNum());
		
	    request.setAttribute("bulletin", vo);
	    
	    System.out.println("jsp테스트 화면 테스트입니다.");
		CommentDAO cDao = CommentDAO.getInstance();
	   List<CommentVO>list = new ArrayList<CommentVO>();
	   int bulletinNum = (int) request.getAttribute("bulletinNum");
	   System.out.println("게시글번호출력테스트>>" + bulletinNum);
	   list = cDao.getComments(bulletinNum);
	   System.out.println("게시글번호출력테스트>>" + bulletinNum);
	   
	   request.setAttribute("comment", list);
	   System.out.println("jsp리스트 값>>" + list);
		
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
