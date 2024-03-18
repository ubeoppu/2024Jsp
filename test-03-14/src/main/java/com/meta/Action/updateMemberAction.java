package com.meta.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meta.dao.MemberDAO;
import com.meta.dto.MemberVO;

public class updateMemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		MemberVO vo = new MemberVO();
		String name = request.getParameter("name");
		String url = "project/Information.jsp";
		
		System.out.println("name>>" + name);
	vo.setName(name);
	vo.setUserid(request.getParameter("userid"));
	vo.setEmail(request.getParameter("email"));
	vo.setPhone(request.getParameter("phone"));
	vo.setAddress(request.getParameter("address"));
	
	int result = MemberDAO.getInstance().updateMember(vo);
	
	System.out.println("result>>" + result);
	
	if(result == 1) {
	session.setAttribute("Member", vo);
	request.setAttribute("message", "수정이 완료되었습니다.");
	url = "project/MyPage.jsp";
	
	}else if(result == -1) {
		request.setAttribute("message", "수정 실패");
	}
	request.getRequestDispatcher(url).forward(request, response);
	}

}
