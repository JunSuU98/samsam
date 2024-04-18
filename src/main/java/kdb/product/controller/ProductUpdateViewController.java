package kdb.product.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdb.product.control.Controller;
import kdb.product.dao.ProductDAO;
import kdb.product.dto.ProductDTO;
import kdb.product.hander.ProductHandlerAdapter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
public class ProductUpdateViewController implements Controller {
	private static Log log = LogFactory.getLog(ProductUpdateViewController.class);
	@Override
	public ProductHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		String product_title = request.getParameter("product_title");
		log.info(product_title);
		int product_price = Integer.parseInt(request.getParameter("product_price"));
		log.info(product_price);
		  int product_number = Integer.parseInt(request.getParameter("product_number"));
		ProductDAO productDAO= new ProductDAO();
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProduct_title(product_title);
		productDTO.setProduct_price(product_price);
		productDTO.setProduct_number(product_number);
		productDTO= productDAO.productUpdate(productDTO);
		request.setAttribute("productDTO", productDTO);
		ProductHandlerAdapter productHandlerAdapter = new ProductHandlerAdapter();
		productHandlerAdapter.setPath("/WEB-INF/view/product_update_view.jsp");
		return productHandlerAdapter;
	}

}
