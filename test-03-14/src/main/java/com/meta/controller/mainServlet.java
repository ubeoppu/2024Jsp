package com.meta.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meta.Action.Action;
import com.meta.Action.ActionFactory;

@WebServlet("/mainServlet")
public class mainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String command= request.getParameter("command");
		
		System.out.println("command값>>" + command);
		ActionFactory af = ActionFactory.getInstance();
		
		
		Action action = af.getAction(command);
		
		if(action != null) {
		action.execute(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		doGet(request, response);
	}

}
