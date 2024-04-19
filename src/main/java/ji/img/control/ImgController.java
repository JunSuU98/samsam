package ji.img.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ji.img.handler.ImgHandlerAdapter;

public interface ImgController {
	public ImgHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;

}
