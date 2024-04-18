package kdb.product.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdb.product.control.Controller;
import kdb.product.dao.ProductDAO;
import kdb.product.dto.ProductDTO;
import kdb.product.hander.ProductHandlerAdapter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
public class ProductUpdateController implements Controller {
	private static Log log = LogFactory.getLog(ProductUpdateController.class);
	@Override
	public ProductHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int product_number = Integer.parseInt(request.getParameter("product_number"));
		log.info(product_number);
		System.out.println(product_number);
		ProductDAO productDAO =new ProductDAO();
		ProductDTO productDTO = new ProductDTO();
		productDTO =productDAO.productSelect(product_number);
		request.setAttribute("productDTO", productDTO);
		ProductHandlerAdapter productHandlerAdapter = new ProductHandlerAdapter();
		log.info("특정 부서 조회");
		productHandlerAdapter.setPath("/WEB-INF/view/product_update.jsp");
		return productHandlerAdapter;
		
	}

}
