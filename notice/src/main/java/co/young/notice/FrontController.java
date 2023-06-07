package co.young.notice;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.young.notice.command.NoticeDelete;
import co.young.notice.command.NoticeEdit;
import co.young.notice.command.NoticeInsert;
import co.young.notice.command.NoticeInsertForm;
import co.young.notice.command.NoticeList;
import co.young.notice.command.NoticeSelect;
import co.young.notice.command.NoticeUpdate;
import co.young.notice.common.Command;
import co.young.notice.main.command.MainCommand;
import co.young.notice.member.command.AjaxCheckId;
import co.young.notice.member.command.MemberInsert;
import co.young.notice.member.command.MemberJoin;
import co.young.notice.member.command.MemberList;
import co.young.notice.member.command.MemberLogout;
import co.young.notice.member.command.memberLogin;
import co.young.notice.member.command.memberLogingo;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();
       
    public FrontController() {
        super();

    }


	public void init(ServletConfig config) throws ServletException {
		//처음 시작될 때 동작되는 메소드
		map.put("/main.do", new MainCommand()); //처음 들어오는 페이지를 돌려준다.
		map.put("/noticeList.do", new NoticeList()); // 게시글 목록보기 
		map.put("/noticeSelect.do", new NoticeSelect()); //게시글 상세보기
		map.put("/noticeInsertForm.do", new NoticeInsertForm()); //게시글 작성 폼 호출
		map.put("/noticeEdit.do", new NoticeEdit()); //게시글 수정폼 호출
		map.put("/noticeUpdate.do", new NoticeUpdate()); //게시글 수정
		map.put("/noticeInsert.do", new NoticeInsert());//새글등록
		map.put("/noticeDelete.do", new NoticeDelete()); // 글 삭제
		map.put("/memberList.do", new MemberList()); // 멤버 목록 보기
		map.put("/memberJoin.do", new MemberJoin()); // 회언가입 화면 노출
		map.put("/memberInsert.do", new MemberInsert()); // 회원가입 수행
		map.put("/ajaxCheckId.do", new AjaxCheckId()); //아이디 중복체크
		map.put("/memberLogin.do", new memberLogin()); //로그인 기능
		map.put("/memberLogingo.do", new memberLogingo()); //로그인 기능
		map.put("/memberLogout.do", new MemberLogout()); //로그아웃 처리
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
			
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
			
		}else {
			response.sendRedirect(viewPage);  //결과가 *.do 이면 위임해버림
		}

	}

}
