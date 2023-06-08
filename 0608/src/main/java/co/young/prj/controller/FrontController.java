package co.young.prj.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.young.prj.MainCommand;
import co.young.prj.common.Command;
import co.young.prj.member.command.Contact;
import co.young.prj.projects.command.Projects;
import co.young.prj.resume.command.Resume;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();
	
	
	public FrontController() {
		super();
	}
	
	
	public void init(ServletConfig config) throws ServletException{
		map.put("/main.do", new MainCommand());
		map.put("/resume.do", new Resume());
		map.put("/projects.do", new Projects());
		map.put("/contact.do", new Contact());
		
		
	}
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서비스 하는 부분
		// 요청을 분석하고, 수행할 command를 찾아서 수행하고, 결과를 돌려준다.
		request.setCharacterEncoding("utf-8"); //한글 깨짐 방지
		String uri = request.getRequestURI(); //호출한 URI를 구한다
		String contextPath = request.getContextPath(); //root를 구함
		String page  = uri.substring(contextPath.length()); // 요청한 페이지 구함
		
		Command command = map.get(page); //수행할 command를 가져온다.
		String viewPage = command.exec(request, response);
		
		if(!viewPage.endsWith(".do")) {
			 if(viewPage.startsWith("Ajax:")) {
				 response.setContentType("text/html; charset=UTF-8");
				 response.getWriter().append(viewPage.substring(5));
				 return;
			 }
			
			//viewPage = "WEB-INF/views/" + viewPage + ".jsp";
			 viewPage += ".tiles"; 
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
			
		}else {
			response.sendRedirect(viewPage);  //결과가 *.do 이면 위임해버림
		}

	}
	
	
	
	
}
