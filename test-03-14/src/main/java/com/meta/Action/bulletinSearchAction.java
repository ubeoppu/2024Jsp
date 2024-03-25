package com.meta.Action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meta.dao.BulletinDAO;
import com.meta.dto.BulletinVO;

public class bulletinSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String searchField =request.getParameter("searchField");
		System.out.println("서치필드>" + searchField);
		String searchText = request.getParameter("searchText");
		System.out.println("서치텍스트>" + searchText);
		
		List<BulletinVO>list = new ArrayList<BulletinVO>();
		
	    list= BulletinDAO.getInstance().getSearch(searchField, searchText);
	    
	    System.out.println("list값이에여여!" + list);
		
		request.setAttribute("bulletinWish", list);
		
		request.getRequestDispatcher("project/bulletinWishListView.jsp").forward(request, response);
	}

}
