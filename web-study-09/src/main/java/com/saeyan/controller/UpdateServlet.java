package com.saeyan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

@WebServlet("/memberUpdate.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		System.out.println("memberUpdate:" + userid);
		
		MemberDAO mDao = MemberDAO.getInstance();
		
		MemberVO vo = mDao.getMember(userid);
		HttpSession session = request.getSession();
		
		if(session != null) {
			session.setAttribute("mVo", vo);
		}
		
		request.getRequestDispatcher("member/memberUpdate.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		System.out.println("memberUpdate!!post >> " + name);
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String admin = request.getParameter("admin");
		
		MemberDAO mDao =MemberDAO.getInstance();
		
		MemberVO vo = new MemberVO();
		
		vo.setName(name);
		vo.setUserid(userid);
		vo.setPwd(pwd);
		vo.setEmail(email);
		vo.setPhone(phone);
		vo.setAdmin(Integer.parseInt(admin));
		
		int result = mDao.updateMember(vo);
		
		if(result == 1) {
//			HttpSession session = request.getSession();
//			session.setAttribute("message", "회원정보 변경완료!");

			response.sendRedirect("member/login.jsp");
		
		}
		
		
	}

}
