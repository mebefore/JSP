package co.young.notice.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.young.notice.common.Command;
import co.young.notice.member.service.MemberService;
import co.young.notice.member.service.MemberVO;
import co.young.notice.member.serviceImpl.MemberServiceImpl;

public class AjaxCheckId implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//아이디 중복체크(Ajax 리턴)
		MemberService ms = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("id"));
		vo = ms.memberSelect(vo);
		String str = "Ajax:";
		
		if(vo != null) {
			str += "No";
		}else {
			str += "Yes";
		}
		return str;
	}

}
