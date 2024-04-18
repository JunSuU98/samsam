package su.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import su.member.control.Controller;
import su.member.dao.MemberDAO;
import su.member.dto.MemberDTO;
import su.member.handler.MemberHandlerAdapter;

public class MemberInsertController implements Controller {
	private static Log log = LogFactory.getLog(MemberInsertController.class);

	@Override
	public MemberHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		String member_id = request.getParameter("member_id");
		String member_password = request.getParameter("member_password");
		String member_name = request.getParameter("member_name");
		String member_email = request.getParameter("member_email");
		String member_phone = request.getParameter("member_phone");
		String member_address = request.getParameter("member_address");
		String member_birth = request.getParameter("member_birth");
		String member_create = request.getParameter("member_create");
		
		System.out.println(member_create);
		System.out.println(member_birth);
		
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setMember_id(member_id);
		memberDTO.setMember_password(member_password);
		memberDTO.setMember_name(member_name);
		memberDTO.setMember_email(member_email);
		memberDTO.setMember_phone(member_phone);
		memberDTO.setMember_address(member_address);
		memberDTO.setMember_birth(member_birth);
		memberDTO.setMember_create(member_create);
		
		MemberDAO memberDAO = new MemberDAO();
		memberDAO.memberInsert(memberDTO);
		log.info("DTO 확인 - "+ memberDTO);
		
		log.info("회원 정보 등록");

		MemberHandlerAdapter memberHandlerAdapter = new MemberHandlerAdapter();
		memberHandlerAdapter.setPath("/WEB-INF/view/member/member_insert.jsp");

		return memberHandlerAdapter;
	}

}
