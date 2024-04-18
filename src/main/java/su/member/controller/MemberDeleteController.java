package su.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import su.member.control.Controller;
import su.member.dao.MemberDAO;
import su.member.dto.MemberDTO;
import su.member.handler.MemberHandlerAdapter;

public class MemberDeleteController implements Controller {
	private static Log log = LogFactory.getLog(MemberDeleteController.class);

	@Override
	public MemberHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		int member_number = Integer.parseInt(request.getParameter("member_number"));
		
		MemberDAO memberDAO = new MemberDAO();
		
		memberDAO.memberDelete(member_number);
		
		HttpSession httpSession = request.getSession();
		
		// 관리자가 아닌 회원이 회원탈퇴를 하는경우, 이전에 로그인 했을 때 만들었던 세션을 삭제한다
		if(!httpSession.getAttribute("member_id").equals("test2")) {
			httpSession.invalidate();
		}

		MemberHandlerAdapter memberHandlerAdapter = new MemberHandlerAdapter();
		memberHandlerAdapter.setPath("/WEB-INF/view/member/member_delete.jsp");		

		return memberHandlerAdapter;
	}

}
