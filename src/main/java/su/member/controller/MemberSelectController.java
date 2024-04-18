package su.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import su.member.control.Controller;
import su.member.dao.MemberDAO;
import su.member.dto.MemberDTO;
import su.member.handler.MemberHandlerAdapter;

public class MemberSelectController implements Controller {
	
	private static Log log = LogFactory.getLog(MemberSelectController.class);

	@Override
	public MemberHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		MemberDAO memberDAO = new MemberDAO();
		
		ArrayList<MemberDTO> arrayList = new ArrayList<MemberDTO>();
		arrayList = memberDAO.memberSelectAll();
		log.info("전체 회원 리스트 - " + arrayList);
		
		request.setAttribute("arrayList", arrayList);
		log.info("회원 정보 조회");
		
		MemberHandlerAdapter memberHandlerAdapter = new MemberHandlerAdapter();
		memberHandlerAdapter.setPath("/WEB-INF/view/member/member_select_view.jsp");

		return memberHandlerAdapter;
	}

}
