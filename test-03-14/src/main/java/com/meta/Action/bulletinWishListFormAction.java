package com.meta.Action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meta.dao.BulletinWishListDAO;
import com.meta.dto.BulletinVO;

public class bulletinWishListFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String userid= (String) session.getAttribute("userid");
		
		BulletinWishListDAO bwDao= BulletinWishListDAO.getInstace();
		
		List<Integer>list = new ArrayList<Integer>();
		
		list = bwDao.getBulletinNums(userid);
		
		System.out.println("list>>>" + list);
		
		List<BulletinVO>voList = new ArrayList<BulletinVO>();
		voList = bwDao.getBulletinWishList(list);
		
		System.out.println("voList>>" + voList);
		
		request.setAttribute("bulletinWish", voList);
		
		request.getRequestDispatcher("project/bulletinWishListView.jsp")
		.forward(request, response);

	}

}
