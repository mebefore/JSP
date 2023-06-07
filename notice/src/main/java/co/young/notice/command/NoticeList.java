package co.young.notice.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.young.notice.common.Command;
import co.young.notice.service.NoticeService;
import co.young.notice.service.NoticeVO;
import co.young.notice.service.Impl.NoticeServiceImpl;

public class NoticeList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//게시글 목록 가져오기
		NoticeService ns = new NoticeServiceImpl(); //모델을 호출
		List<NoticeVO> notices = new ArrayList<>(); //결과를 담을 것
		notices = ns.noticeSelectList();
		
		request.setAttribute("notices", notices); //JSP에 보내기 위해 결과 객체를 담는다.
		return "notice/noticeList";
		
	}

}