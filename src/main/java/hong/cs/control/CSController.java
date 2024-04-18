package hong.cs.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hong.cs.handler.CSHandlerAdapter;

public interface CSController {
	public CSHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response);
}