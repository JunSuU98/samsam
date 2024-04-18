package su.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import su.member.control.Controller;
import su.member.dao.MemberDAO;
import su.member.dto.MemberDTO;
import su.member.handler.MemberHandlerAdapter;

public class MemberUpdateController implements Controller {
	private static Log log = LogFactory.getLog(MemberUpdateController.class);

	@Override
	public MemberHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		int member_number = Integer.parseInt(request.getParameter("member_number"));		
		String member_id = request.getParameter("member_id");
		String member_password = request.getParameter("member_password");
		String member_name = request.getParameter("member_name");
		String member_email = request.getParameter("member_email");
		String member_phone = request.getParameter("member_phone");
		String member_address = request.getParameter("member_address");
		String member_birth = request.getParameter("member_birth");
		String member_update = request.getParameter("member_update");

		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setMember_number(member_number);
		memberDTO.setMember_id(member_id);
		memberDTO.setMember_password(member_password);
		memberDTO.setMember_name(member_name);
		memberDTO.setMember_email(member_email);
		memberDTO.setMember_phone(member_phone);
		memberDTO.setMember_address(member_address);
		memberDTO.setMember_birth(member_birth);
		memberDTO.setMember_update(member_update);
		
		memberDTO = memberDAO.memberUpdate(memberDTO);
		log.info("update memberDTO - " + memberDTO);
		
		request.setAttribute("memberDTO", memberDTO);
		
		MemberHandlerAdapter memberHandlerAdapter = new MemberHandlerAdapter();
		memberHandlerAdapter.setPath("/WEB-INF/view/member/member_update.jsp");
		return memberHandlerAdapter;

//		return null;
	}

}
