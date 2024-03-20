package com.meta.Action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meta.dao.ContentWishListDAO;
import com.meta.dto.ContentVO;

public class contentWishListFormAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("왜 안찍혀 ;");
		
		HttpSession session = request.getSession();
		
		String userid =(String)session.getAttribute("userid");
		
		System.out.println("콘텐트위시리스트 아이디 >>" +userid);
		
		ContentWishListDAO cWDao=ContentWishListDAO.getInstace();
		
		
		List<Integer>list = new ArrayList<Integer>();
		
		list = cWDao.getContentNums(userid);
		
		System.out.println("ContentNumlist>>" + list);
		
		List<ContentVO>Clist = new ArrayList<ContentVO>();
		
		Clist = cWDao.getContentWishList(list);
		
		System.out.println("Clist>>" + Clist);
		
		request.setAttribute("contentWish", Clist);
		
		
		request.getRequestDispatcher("project/contentWishListView.jsp").forward(request, response);

	}

}
