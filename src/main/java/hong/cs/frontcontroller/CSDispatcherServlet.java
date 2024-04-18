package hong.cs.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hong.cs.control.CSController;
import hong.cs.controller.CSDeleteContorller;
import hong.cs.controller.CSInsertController;
import hong.cs.controller.CSSelectController;
import hong.cs.controller.CSSelectDetailController;
import hong.cs.controller.CSUpdateViewController;
import hong.cs.controller.CSUpdateController;
import hong.cs.handler.CSHandlerAdapter;

//@WebServlet("/CSDispatcherServlet") → web.xml에서 서블릿 설정했으므로 어노테이션 설정X
public class CSDispatcherServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(CSDispatcherServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String pathURL = requestURI.substring(contextPath.length());
		log.info("맵핑명 조회 - " + pathURL);
		CSHandlerAdapter csHandlerAdapter = null;
		CSController csController = null;

		if (pathURL.equals("/CSSelect.cs")) {
			csController = new CSSelectController();
			csHandlerAdapter = csController.execute(request, response);
			log.info("고객문의 조회 확인 - " + csHandlerAdapter);
		}

		else if (pathURL.equals("/CSSelectDetail.cs")) {
			csController = new CSSelectDetailController();
			csHandlerAdapter = csController.execute(request, response);
			log.info("상세문의 조회 확인 - " + csHandlerAdapter);
		}

		else if (pathURL.equals("/CSInsertView.cs")) {
			csHandlerAdapter = new CSHandlerAdapter();
			csHandlerAdapter.setPath("/WEB-INF/cs_view/cs_insert_view.jsp");
			log.info("문의 등록 화면 뷰 확인 - " + csHandlerAdapter);
		}
		
		else if (pathURL.equals("/CSInsert.cs")) {
			csController=new CSInsertController();
			csHandlerAdapter=csController.execute(request, response);
			log.info("문의 등록 확인 - "+csHandlerAdapter);
		}
		
		else if (pathURL.equals("/CSUpdateView.cs")) {
			csController=new CSUpdateViewController();
			csHandlerAdapter=csController.execute(request, response);
			log.info("문의 수정 화면 뷰 확인 - "+csHandlerAdapter);
		}
		
		else if (pathURL.equals("/CSUpdate.cs")) {
			csController=new CSUpdateController();
			csHandlerAdapter=csController.execute(request, response);
			log.info("문의 수정 확인 - "+csHandlerAdapter);
		}
		
		else if (pathURL.equals("/CSDeleteView.cs")) {
			csHandlerAdapter=new CSHandlerAdapter();
			csHandlerAdapter.setPath("/WEB-INF/cs_view/cs_delete_view.jsp");
			log.info("문의 삭제 화면 뷰 확인 - "+csHandlerAdapter);
		}
		
		else if (pathURL.equals("/CSDelete.cs")) {
			csController=new CSDeleteContorller();
			csHandlerAdapter=csController.execute(request, response);
			log.info("문의 삭제 확인 - "+csHandlerAdapter);
		}
		

		if (csHandlerAdapter != null) {
			if (csHandlerAdapter.isRedirect()) {
				response.sendRedirect(csHandlerAdapter.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(csHandlerAdapter.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
}