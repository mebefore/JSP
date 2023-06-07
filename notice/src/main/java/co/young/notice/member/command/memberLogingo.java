package co.young.notice.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.young.notice.common.Command;
import co.young.notice.member.service.MemberService;
import co.young.notice.member.service.MemberVO;
import co.young.notice.member.serviceImpl.MemberServiceImpl;

public class memberLogingo implements Command {
	//로그인 처리
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//로그인 처리
		MemberService ms = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession();
		
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		
		vo = ms.memberLogin(vo);
		if(vo != null) {
			session.setAttribute("id", vo.getMemberId()); 
			session.setAttribute("name", vo.getMemberName()); 
			request.setAttribute("message", vo.getMemberName() + "님 환영합니다.");
		}else {
			request.setAttribute("message", "아이디 또는 비밀번호를 확인하세요.");
		}
		
		return "member/memberMessage";
	}

}
