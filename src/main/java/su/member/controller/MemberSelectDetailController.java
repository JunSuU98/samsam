package su.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import su.member.control.Controller;
import su.member.dao.MemberDAO;
import su.member.dto.MemberDTO;
import su.member.handler.MemberHandlerAdapter;

public class MemberSelectDetailController implements Controller {
	private static Log log = LogFactory.getLog(MemberSelectDetailController.class);

	@Override
	public MemberHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		int member_number = Integer.parseInt(request.getParameter("member_number"));
		log.info(member_number);
		
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO = memberDAO.memberSelect(member_number);
		log.info("상세조회 dto - " + memberDTO);
		
		request.setAttribute("memberDTO", memberDTO);
		
		MemberHandlerAdapter memberHandlerAdapter = new MemberHandlerAdapter();
		memberHandlerAdapter.setPath("/WEB-INF/view/member/member_select_detail_view.jsp");
		
		log.info("상세 회원 조회");

		return memberHandlerAdapter;
	}

}
