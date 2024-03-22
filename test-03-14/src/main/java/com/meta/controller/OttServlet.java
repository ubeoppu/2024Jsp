package com.meta.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meta.Action.Action;
import com.meta.Action.ActionFactory;
import com.meta.dao.ContentDAO;
import com.meta.dto.ContentVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/OttServlet")
public class OttServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String command= request.getParameter("command");
		System.out.println("Ott서블릿 작동됨");
		System.out.println("command값>>" + command);
		ActionFactory af = ActionFactory.getInstance();
//        ServletContext context = request.getSession().getServletContext();
//        String path = context.getRealPath("images");
//        System.out.println("path>>" + path);
		
		Action action = af.getAction(command);
		
		if(action != null) {
		action.execute(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("asdasd");
	     String contentType = request.getContentType();
	      
	      if(contentType != null && contentType.startsWith("multipart/form-data")) {
	         ServletContext context = request.getSession().getServletContext();
	         String path = context.getRealPath("images");
	         System.out.println("path>>" + path);
	         String encType = "utf-8";
	         int sizeLimit = 20*1024*1024;
	         
	         MultipartRequest multi = new MultipartRequest(
	               request,path,sizeLimit,encType,new DefaultFileRenamePolicy());
	         
	         String command = multi.getParameter("command");
	         ActionFactory af = ActionFactory.getInstance();
	         
	         Action action = af.getAction(command);
	         
	         if(action != null) {
	        	 action.execute(request, response);
	         }
	         
	         ContentVO vo = new ContentVO();
	         
	         vo.setContentNum(Integer.parseInt(multi.getParameter("contentNum")));
	         vo.setContentName(multi.getParameter("contentName"));
	         vo.setGenre(multi.getParameter("genre"));
	         vo.setActor(multi.getParameter("actor"));
	         vo.setYear(Integer.parseInt(multi.getParameter("year")));
	         vo.setStory(multi.getParameter("story"));
	         vo.setPoster("images"+multi.getOriginalFileName("poster"));

	         
//	         if(command.equals("insert_content")) {
//	            ContentDAO.getInstance().insertContent(vo);
//	            response.sendRedirect("OttServlet?command=content_info");            
//	         }else if(command.equals("update_content")) {
//	            
//	            if(multi.getOriginalFileName("poster")==null) {
//	               vo.setPoster("images/" + multi.getOriginalFileName("nomakeImg"));
//	            }else {
//	               vo.setPoster("images/"+multi.getOriginalFileName("poster"));               
//	            }
//	            
//	            ContentDAO.getInstance().updateContent(vo);
//	            response.sendRedirect("OttServlet?command=content_info");                        
//	         }
//	         
	         
//	         return;
	      }
	      else {
	         response.setContentType("text/html; charset=utf-8");
	         doGet(request, response);
	      }
	      
	}
}
