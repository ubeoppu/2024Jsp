package com.meta.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meta.dao.MemberDAO;

public class deleteMemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String userid = (String)session.getAttribute("userid");
		System.out.println("테스트");
		System.out.println("테스트아이디>>" + userid);
		MemberDAO.getInstance().deleteMember(userid);
		
		request.getRequestDispatcher("project/login.jsp").forward(request, response);

	}

}
