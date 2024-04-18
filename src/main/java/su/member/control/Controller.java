package su.member.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import su.member.handler.MemberHandlerAdapter;

public interface Controller {
	public MemberHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response);
}
