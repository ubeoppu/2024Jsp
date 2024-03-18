package com.meta.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meta.dao.MemberDAO;
import com.meta.dto.MemberVO;

public class changeUserInformationFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("userid");
		System.out.println("id>>" + id);
		MemberVO vo = MemberDAO.getInstance().getOneMember(id);
		
		request.setAttribute("Member", vo);
		System.out.println("vo>>" + vo);
		request.getRequestDispatcher("project/Information.jsp")
		.forward(request, response);

		
		

	}

}
