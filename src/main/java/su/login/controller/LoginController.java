package su.login.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import su.member.control.Controller;
import su.member.dao.MemberDAO;
import su.member.dto.MemberDTO;
import su.member.handler.MemberHandlerAdapter;

public class LoginController implements Controller {
	private static Log log = LogFactory.getLog(LoginController.class);

	@Override
	public MemberHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		String member_id = request.getParameter("member_id");
		String member_password = request.getParameter("member_password");
		
		
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setMember_id(member_id);
		memberDTO.setMember_password(member_password);
		
		MemberDAO memberDAO = new MemberDAO();		

		memberDTO = memberDAO.memberLogin(memberDTO);
		log.info("로그인 내용 - " + memberDTO);
		
		request.setAttribute("memberDTO", memberDTO);
		
		if(!memberDTO.getMember_id().equals("") & !memberDTO.getMember_password().equals("")) {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("member_number", memberDTO.getMember_number());
			httpSession.setAttribute("member_id", memberDTO.getMember_id());
			httpSession.setAttribute("member_name", memberDTO.getMember_name());
			
			Cookie cookie = new Cookie("id", memberDTO.getMember_id());
			cookie.setMaxAge(60 * 60 * 24);
			cookie.setPath("/");

			response.addCookie(cookie);
			
		}
		
		MemberHandlerAdapter memberHandlerAdapter = new MemberHandlerAdapter();
		memberHandlerAdapter.setPath("WEB-INF/view/login/login_check.jsp");
		
		return memberHandlerAdapter;
	}

}
