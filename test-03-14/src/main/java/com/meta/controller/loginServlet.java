package com.meta.controller;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meta.dao.MemberDAO;
import com.meta.dto.MemberVO;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("html/text; charset=utf-8");
		request.getRequestDispatcher("project/login.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		List<MemberVO>list = new ArrayList<MemberVO>();
		
		String id = request.getParameter("userid");
		String pass = request.getParameter("pwd");
		String url = "project/login.jsp";
		
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.checkUser(id, pass);
		list = mDao.getAllMember(id);
		
		
		HttpSession session = request.getSession();
		
		session.setAttribute("Member", list);
		System.out.println("result받은 값 >>"+result);;
		//1 : 로그인 성공 0 : 비밀번호 틀림 -1 : 아이디 틀림
		if(result == 1) {
		    url = "project/MyPage.jsp";
		    session.setAttribute("userid", id);
		}else if(result == 0) {
			request.setAttribute("message", "비밀번호가 틀렸습니다");
		}else if(result == -1) {
			request.setAttribute("message", "아이디가 틀렸습니다");
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
