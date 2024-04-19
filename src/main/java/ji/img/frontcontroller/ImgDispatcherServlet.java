package ji.img.frontcontroller;

import java.io.IOException;
import ji.img.control.ImgController;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ji.img.controller.ImgDeleteController;
import ji.img.controller.ImgInsertController;
import ji.img.controller.ImgSelectController;
import ji.img.controller.ImgSelectDetailController;
import ji.img.controller.ImgUpdateController;
import ji.img.controller.ImgUpdateViewController;
import ji.img.handler.ImgHandlerAdapter;

@WebServlet("/ImgDispatcherServlet")
public class ImgDispatcherServlet extends HttpServlet implements Servlet{
	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(ImgDispatcherServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String pathURL = requestURI.substring(contextPath.length());
		log.info("매핑명 조회 - " + pathURL);
		
		ImgHandlerAdapter imgHandlerAdapter = null;
		ji.img.control.ImgController controller = null;
		
//		Controller controller = null;
		
		if (pathURL.equals("/ImgSelect.im")) {
			controller = new ImgSelectController();
			imgHandlerAdapter = controller.execute(request, response);
			log.info("이미지 조회 확인 - " + imgHandlerAdapter);
		}
		
		else if (pathURL.equals("/ImgSelectDetail.im")) {
			controller = new ImgSelectDetailController();
			imgHandlerAdapter = controller.execute(request, response);
			log.info("상세 이미지 조회 확인 - " + imgHandlerAdapter);
		}
		
		else if (pathURL.equals("/ImgInsertView.im")) {
			imgHandlerAdapter = new ImgHandlerAdapter();
			
			imgHandlerAdapter.setPath("./image/img_insert.jsp");
			log.info("이미지 등록 화면 뷰 확인 - " + imgHandlerAdapter);
		}
		
		else if (pathURL.equals("/ImgInsert.im")) {
			controller = new ImgInsertController();
			imgHandlerAdapter = controller.execute(request, response);
			log.info("이미지 등록 확인 - " + imgHandlerAdapter);
		}
		
		else if(pathURL.equals("/ImgUpdateView.im")) {
			controller = new ImgUpdateViewController( );
			imgHandlerAdapter = controller.execute(request, response); 
			log.info("이미지 수정 화면 뷰 확인 - " + imgHandlerAdapter);
			}
		
		else if(pathURL.equals("/ImgUpdate.im")) {
			controller = new ImgUpdateController( ); 
			imgHandlerAdapter = controller.execute(request, response); 
			log.info("이미지 수정 확인 - " + imgHandlerAdapter);
			}
		
		else if (pathURL.equals("/ImgDeleteView.im")) {
			imgHandlerAdapter = new ImgHandlerAdapter();
			
			imgHandlerAdapter.setPath("./image/img_delete.jsp");
			log.info("이미지 삭제 화면 뷰 확인 - " + imgHandlerAdapter);
		}
		
		else if (pathURL.equals("/ImgDelete.im")) {
			controller = new ImgDeleteController();
			imgHandlerAdapter = controller.execute(request, response);
			
			log.info("이미지 삭제 확인 - " + imgHandlerAdapter);
		}
		
		
		if (imgHandlerAdapter != null) {
			if (imgHandlerAdapter.isRedirect()) {
				response.sendRedirect(imgHandlerAdapter.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(imgHandlerAdapter.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
}
