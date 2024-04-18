package kdb.product.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdb.product.control.Controller;
import kdb.product.dao.ProductDAO;
import kdb.product.dto.ProductDTO;
import kdb.product.hander.ProductHandlerAdapter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
public class ProductDeleteController  implements Controller{
	private static Log log = LogFactory.getLog(ProductDeleteController.class);
	@Override
	public ProductHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int product_number =Integer.parseInt(request.getParameter("product_number"));
		ProductDAO productDAO = new ProductDAO();
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProduct_number(product_number);
		request.setAttribute("productDTO", productDTO);
		productDTO = productDAO.productDelete(product_number);
		ProductHandlerAdapter productHandlerAdapter = new ProductHandlerAdapter();
		productHandlerAdapter.setPath("/WEB-INF/view/product_delete_view.jsp");
		return productHandlerAdapter;
	}

}
