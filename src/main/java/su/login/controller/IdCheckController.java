package su.login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import su.member.control.Controller;
import su.member.dao.MemberDAO;
import su.member.handler.MemberHandlerAdapter;

public class IdCheckController implements Controller {
	private static final Log log = LogFactory.getLog(IdCheckController.class);
	
	@Override
	public MemberHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		String member_id = request.getParameter("member_id");
		System.out.println("member_id - " + member_id);
		
		MemberDAO memberDAO = new MemberDAO();
		
		int result = memberDAO.memberIdCheck(member_id);
		System.out.println("result - " + result);
		
		if(result == 1) {
			log.info("존재하는 아이디 - " + member_id);
		} else if(result == 0) {
			log.info("존재하지 않는 아이디 - " + member_id);
		}
		
		try {
			PrintWriter out = response.getWriter();
			out.write(result + "");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
