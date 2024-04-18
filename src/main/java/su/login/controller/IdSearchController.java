package su.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import su.member.control.Controller;
import su.member.dao.MemberDAO;
import su.member.dto.MemberDTO;
import su.member.handler.MemberHandlerAdapter;

public class IdSearchController implements Controller {
	private static final Log log = LogFactory.getLog(IdSearchController.class);

	@Override
	public MemberHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		String member_name = request.getParameter("member_name");
		String member_birth = request.getParameter("member_birth");
		String member_phone = request.getParameter("member_phone");
		
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setMember_name(member_name);
		memberDTO.setMember_birth(member_birth);
		memberDTO.setMember_phone(member_phone);
		
		MemberDAO memberDAO = new MemberDAO();
		memberDTO = memberDAO.memberSearchId(memberDTO);
		
		
		request.setAttribute("memberDTO", memberDTO);
		
		MemberHandlerAdapter memberHandlerAdapter = new MemberHandlerAdapter();
		memberHandlerAdapter.setPath("/WEB-INF/view/login/id_search.jsp");
		
		return memberHandlerAdapter;
	}

}
