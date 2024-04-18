package su.member.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import su.login.controller.IdCheckController;
import su.login.controller.IdSearchController;
import su.login.controller.LoginController;
import su.login.controller.LogoutController;
import su.login.controller.PasswordSearchController;
import su.member.control.Controller;
import su.member.controller.MemberDeleteController;
import su.member.controller.MemberInsertController;
import su.member.controller.MemberSelectController;
import su.member.controller.MemberSelectDetailController;
import su.member.controller.MemberUpdateController;
import su.member.controller.MemberUpdateViewController;
import su.member.handler.MemberHandlerAdapter;

public class MemberDispatcherServlet extends HttpServlet {
	private static Log log = LogFactory.getLog(MemberDispatcherServlet.class);

	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String pathURL = requestURI.substring(contextPath.length());
		
		log.info("매핑명 조회 - " + pathURL);
		
		MemberHandlerAdapter memberHandlerAdapter = null;
		
		Controller controller = null;
		
		if(pathURL.equals("/MemberSelect.me")){
			controller = new MemberSelectController();
			memberHandlerAdapter = controller.execute(request, response);			
			
			log.info("회원 전체 조회 확인 - " + memberHandlerAdapter);
		}
		
		else if(pathURL.equals("/MemberSelectDetail.me")) {
			controller = new MemberSelectDetailController();
			memberHandlerAdapter = controller.execute(request, response);
			
			log.info("회원 상세 조회 확인 - " + memberHandlerAdapter);
		}
		
		else if(pathURL.equals("/MemberInsertView.me")) {
			memberHandlerAdapter = new MemberHandlerAdapter();
			memberHandlerAdapter.setPath("/WEB-INF/view/member/member_insert_view.jsp");

			log.info("회원가입 화면 뷰 확인 - " + memberHandlerAdapter);
		}
		
		else if(pathURL.equals("/MemberInsert.me")) {
			controller = new MemberInsertController();
			memberHandlerAdapter = controller.execute(request, response);
			
			log.info("회원 가입 확인 - " + memberHandlerAdapter);
		}
		
		else if(pathURL.equals("/MemberUpdateView.me")) {
			controller = new MemberUpdateViewController();
			memberHandlerAdapter = controller.execute(request, response);
			
			log.info("정보 수정 뷰 확인 - " + memberHandlerAdapter);
		}
		
		else if(pathURL.equals("/MemberUpdate.me")) {
			controller = new MemberUpdateController();
			memberHandlerAdapter = controller.execute(request, response);
					
			log.info("정보 수정 확인 - " + memberHandlerAdapter);
		}
		
		else if(pathURL.equals("/MemberDeleteView.me")) {
			memberHandlerAdapter = new MemberHandlerAdapter();
			memberHandlerAdapter.setPath("/WEB-INF/view/member/member_delete_view.jsp");
			
			log.info("회원 삭제 화면 뷰 확인 - " + memberHandlerAdapter);
		}
		
		else if(pathURL.equals("/MemberDelete.me")) {
			controller = new MemberDeleteController();
			memberHandlerAdapter = controller.execute(request, response);
			
			log.info("회원 삭제 확인 - " + memberHandlerAdapter);
			
		}
		
		else if(pathURL.equals("/LoginView.me")) {
			memberHandlerAdapter = new MemberHandlerAdapter();
			memberHandlerAdapter.setPath("/WEB-INF/view/login/login_view.jsp");
			
			log.info("로그인 화면 뷰 확인 - " + memberHandlerAdapter);
		}
		
		else if(pathURL.equals("/Login.me")) {
			controller = new LoginController();
			memberHandlerAdapter = controller.execute(request, response);
			
			log.info("로그인 확인 - " + memberHandlerAdapter);
		}
		
		else if(pathURL.equals("/Logout.me")) {
			controller = new LogoutController();
			memberHandlerAdapter = controller.execute(request, response);
			
			log.info("로그아웃 확인 - " + memberHandlerAdapter);
		}
		
		else if(pathURL.equals("/IdSearchView.me")) {
			memberHandlerAdapter = new MemberHandlerAdapter();
			memberHandlerAdapter.setPath("/WEB-INF/view/login/id_search_view.jsp");
			
			log.info("아이디 찾기 뷰 확인 - " + memberHandlerAdapter);
		}
		
		else if(pathURL.equals("/IdSearch.me")) {
			controller = new IdSearchController();
			memberHandlerAdapter = controller.execute(request, response);
			
			log.info("아이디 찾기 확인 - " + memberHandlerAdapter);
			
		}
		
		else if(pathURL.equals("/PasswordSearchView.me")) {
			memberHandlerAdapter = new MemberHandlerAdapter();
			memberHandlerAdapter.setPath("/WEB-INF/view/login/password_search_view.jsp");
			
			log.info("비밀번호 찾기 뷰 확인 - " + memberHandlerAdapter);
			
		}
		
		else if(pathURL.equals("/PasswordSearch.me")) {
			controller = new PasswordSearchController();
			memberHandlerAdapter = controller.execute(request, response);
			
			log.info("비밀번호 찾기 - " + memberHandlerAdapter);
			
		}
		
		else if(pathURL.equals("/IdCheck.me")){
			controller = new IdCheckController();
			memberHandlerAdapter = controller.execute(request, response);
			
			log.info("아이디 중복 확인 - " + memberHandlerAdapter);
		}
		
		
		if(memberHandlerAdapter != null) {
			if(memberHandlerAdapter.isRedirect()) {
				response.sendRedirect(memberHandlerAdapter.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(memberHandlerAdapter.getPath());
				dispatcher.forward(request, response);
			}
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
