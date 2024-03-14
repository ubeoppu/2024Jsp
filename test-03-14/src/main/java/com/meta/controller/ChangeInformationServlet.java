package com.meta.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meta.dao.MemberDAO;
import com.meta.dto.MemberVO;

@WebServlet("/ChangeInformationServlet")
public class ChangeInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     response.setContentType("text/html; charset = utf-8");
	 request.getRequestDispatcher("project/ChangeInformation.jsp")
	 .forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		System.out.println("테스트입니다");
		
		
		
	}

}
