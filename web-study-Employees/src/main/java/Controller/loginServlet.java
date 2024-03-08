package Controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.EmployeeDAO;
import VO.EmployeeVO;

@WebServlet("/login.do")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		int number = 0;
		session.setAttribute("number", number);
		
//		request.setAttribute("number", "1");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Employees/login.jsp");
		dispatcher.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		EmployeeDAO eDao = EmployeeDAO.getInstance();
		EmployeeVO vo = new EmployeeVO();
		String id = request.getParameter("id");
		String password = request.getParameter("pass");
		
		vo = eDao.EmployeeInfo(id);
		
		String Empid = vo.getId();
		String pass = vo.getPass();
		String name = vo.getName();
		String lev = vo.getLev();
		String gender = vo.getGender();
		String phone = vo.getPhone();
		System.out.println("pass>>" + pass);
//		PrintWriter out = response.getWriter();
		String url = "Employees/login.jsp";
		
		HttpSession session = request.getSession();
		System.out.println("name>>>" + vo.getName());
		session.setAttribute("id", Empid);
		session.setAttribute("pass", pass);
		session.setAttribute("name", name);
		session.setAttribute("lev", lev);
		session.setAttribute("gender", gender);
		session.setAttribute("phone", phone);
		
		System.out.println("PASSWORD>>>" +pass);
		System.out.println("Id>>" + id);
//		EmployeeVO vo = new EmployeeVO();
//		 vo = eDao.EmployeeInfo(id);
//		System.out.println("서블릿vo값>>>" + vo); 
		
		int result = eDao.EmployeeCheck(id, password);
		
		// -1:아이디 틀림 0:비밀번호 틀림
		if(result == 1) {
			url = "Employees/main.jsp";
		}else if(result == -1) {
			session.setAttribute("message", "아이디가 틀렸습니다");
		}else if(result == 0) {
			session.setAttribute("message", "비밀번호가 틀렸습니다.");
		}
		request.getRequestDispatcher(url)
		.forward(request, response);
		
//		}else if(result == 0) {
//			out.println("<script type =\"text/javascript\" src =\"JavaScript/Employees.js\">");
//			out.println("<script>");
//			out.println("window.onload = fuction(){");
//			out.println("loginPassFail();");
//			out.println("</script>");
//		}else if(result == 1) {
			
//		}

		}
	}

