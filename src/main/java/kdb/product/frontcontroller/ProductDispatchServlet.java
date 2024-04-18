package kdb.product.frontcontroller;

import java.io.IOException;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import kdb.product.control.Controller;
import kdb.product.controller.ProductDeleteController;
import kdb.product.controller.ProductInsertController;
import kdb.product.controller.ProductSelectController;
import kdb.product.controller.ProductSelectDetailController;
import kdb.product.controller.ProductUpdateController;
import kdb.product.controller.ProductUpdateViewController;
import kdb.product.hander.ProductHandlerAdapter;


public class ProductDispatchServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(ProductDispatchServlet.class);
   


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request,response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request,response);
		
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String pathURL=requestURI.substring(contextPath.length());
		log.info("매핑명 조회 - " + pathURL);
		ProductHandlerAdapter productHandlerAdapter = null;
		Controller controller =null;
		if (pathURL.equals("/ProductSelect.pr")) {
			controller =new ProductSelectController();
			productHandlerAdapter =controller.execute(request, response);
			log.info("상품 조회 확인 - " + productHandlerAdapter);
		}
	 else if (pathURL.equals("/ProductSelectDetail.pr")) {
		controller = new ProductSelectDetailController();
		productHandlerAdapter= controller.execute(request, response);
		log.info("상품 상세 조회 확인 - " + productHandlerAdapter);
	}
			else if (pathURL.equals("/ProductInsertView.pr")) {
				productHandlerAdapter = new ProductHandlerAdapter();
				productHandlerAdapter.setPath("/WEB-INF/view/product_insert.jsp");
				log.info("상품 등록 화면 뷰 -"+productHandlerAdapter);
			}
		else if (pathURL.equals("/ProductInsert.pr")) {
			controller = new ProductInsertController();
			productHandlerAdapter =controller.execute(request, response);
			log.info("상품 등록 화면 뷰 확인"+productHandlerAdapter);
		}
		else if(pathURL.equals("/ProductUpdateView.pr")) {
			controller = new ProductUpdateViewController( );
			productHandlerAdapter = controller.execute(request, response);
			log.info("부서 수정 화면 뷰 확인 - " + productHandlerAdapter);
			}

		else if (pathURL.equals("/ProductUpdate.pr")) {
			controller =new ProductUpdateController();
			productHandlerAdapter=controller.execute(request, response);
			log.info("부서 수정 확인"+productHandlerAdapter);
		}
		else if(pathURL.equals("/ProductDeleteView.pr")) {
	productHandlerAdapter= new ProductHandlerAdapter( );
			 productHandlerAdapter.setPath("/WEB-INF/view/product_delete.jsp");
			log.info("상품 삭제 화면 뷰 확인 - " + productHandlerAdapter);
			}
		else if(pathURL.equals("/ProductDelete.pr")) {
			controller = new ProductDeleteController( );
			productHandlerAdapter = controller.execute(request, response);
			log.info("부서 삭제 확인 - " + productHandlerAdapter);
			}
		 if(productHandlerAdapter != null) {
			 if(productHandlerAdapter.isRedirect( )) {
			response.sendRedirect(productHandlerAdapter.getPath( ));
			} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(productHandlerAdapter.getPath( ));
			dispatcher.forward(request, response);

	}
	}
	}
}

