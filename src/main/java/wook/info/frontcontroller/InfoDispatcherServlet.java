	package wook.info.frontcontroller;
	
	import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
	import javax.servlet.ServletException;
	import javax.servlet.ServletRequest;
	import javax.servlet.ServletResponse;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;


import org.apache.commons.logging.Log;
	import org.apache.commons.logging.LogFactory;
	
	import wook.info.frontcontroller.InfoDispatcherServlet;
	import wook.info.control.Controller;
import wook.info.controller.InfoDeleteController;
import wook.info.controller.InfoDeleteViewController;
import wook.info.controller.InfoInsertController;
import wook.info.controller.InfoSelectController;
import wook.info.controller.InfoSelectDetailController;
import wook.info.controller.InfoUpdateController;
import wook.info.controller.InfoUpdateViewController;
import wook.info.controller.InfoUploadController;
import wook.info.hander.InfoHandlerAdapter;
	import wook.info.hander.InfoHandlerAdapter;
	
	
	
	public class InfoDispatcherServlet extends HttpServlet implements Servlet{
		private static final long serialVersionUID = 1L;
		private static Log log = LogFactory.getLog(InfoDispatcherServlet.class);
	
	    
	
	@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   service(request, response);
		}
	
	@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			service(request, response);
		}
	 
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String RequestUri = request.getRequestURI();
	    String ContextPath = request.getContextPath();
	    String PathUri= RequestUri.substring(ContextPath.length());
	    InfoHandlerAdapter infoHandlerAdapter = null ;
	    Controller controller = null;
	    
	    if (PathUri.equals("/InfoSelect.in")) {
	    	controller = new InfoSelectController();
		 infoHandlerAdapter = controller.excute(request, response);
		 log.info("회원 전체 조회 확인 - " + infoHandlerAdapter);
		}
	    else if(PathUri.equals("/InfoSelectDetail.in")){
	    	controller= new InfoSelectDetailController();
	    	infoHandlerAdapter= controller.excute(request, response);
	    log.info("공지 상세보기" + infoHandlerAdapter);
	    }
	    else if (PathUri.equals("/InfoInsert.in")) {
			infoHandlerAdapter= new InfoHandlerAdapter();
			//포워드로 파라미터 전송(새로운 리퀘스트 객체 생성 x)
			infoHandlerAdapter.setPath("/WEB-INF/view/info/info_insert.jsp");
	    log.info("공지 등록"+infoHandlerAdapter);
		}
	    else if (PathUri.equals("/InfoInsertView.in")) {
			controller = new InfoInsertController();
			infoHandlerAdapter= controller.excute(request, response);
		log.info("공지 등록 뷰 확인"+infoHandlerAdapter);
		}
	   else if(PathUri.equals("/InfoUpdate.in")){
		controller= new InfoUpdateController();
		infoHandlerAdapter= controller.excute(request, response);
	 log.info("수정 전 데이터 확인"+infoHandlerAdapter);
	}
	   else if(PathUri.equals("/InfoUpdateView.in")) {
		   controller = new InfoUpdateViewController();
		   infoHandlerAdapter=controller.excute(request, response);
		  log .info("수정 데이터"+infoHandlerAdapter);
	   }
	    
	   else if(PathUri.equals("/InfoDelete.in")) {
		   controller= new InfoDeleteController();
		   infoHandlerAdapter= controller.excute(request, response);
		   log.info("삭제데이터"+ infoHandlerAdapter);
		   
		   		   
	   }
		   
	   else if(PathUri.equals("/InfoDeleteView.in")) { 
		   controller= new InfoDeleteViewController();
		   infoHandlerAdapter= controller.excute(request, response);
		   log.info("삭제데이터"+ infoHandlerAdapter);
		   
	   }
	    
	   else if(PathUri.equals("/InfoUpload.in")) {
		   controller = new InfoUploadController();
		   infoHandlerAdapter = controller.excute(request, response);
		   log.info("파일업로드"+infoHandlerAdapter);
		   
	   }
	    
	    
	   	    
	    
	    
	    if (infoHandlerAdapter != null) {
			if (infoHandlerAdapter.isRedirect()) {
				response.sendRedirect(infoHandlerAdapter.getPath());
			}else {
				RequestDispatcher dispatcher= request.getRequestDispatcher(infoHandlerAdapter.getPath());
				dispatcher.forward(request, response);
			}
		}
		
	}
		
	
	}
