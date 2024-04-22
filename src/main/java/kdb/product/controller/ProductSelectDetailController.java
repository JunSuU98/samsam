package kdb.product.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdb.product.control.Controller;
import kdb.product.dao.ProductDAO;
import kdb.product.dto.ProductDTO;
import kdb.product.hander.ProductHandlerAdapter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ProductSelectDetailController implements Controller {
	private static Log log = LogFactory.getLog(ProductSelectDetailController.class);
	@Override
	public ProductHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int  product_number =Integer.parseInt(request.getParameter("product_number"));
		log.info(product_number);
		
		ProductDAO productDAO= new ProductDAO();
		ProductDTO productDTO= new ProductDTO();
			
		productDTO= productDAO.productSelect(product_number);
		log.info(productDTO);
		
		request.setAttribute("productDTO", productDTO);
		
		
		String img_url = productDAO.productSelectImgUrl(productDTO.getImg_index());
		System.out.println("productDTO.getImg_index() - " + productDTO.getImg_index());
		System.out.println("Product Select Controller img url - " + img_url);
		request.setAttribute("img_url", img_url);
		
		ProductHandlerAdapter productHandlerAdapter = new ProductHandlerAdapter();
		productHandlerAdapter.setPath("/WEB-INF/view/product_view/product_select_detail_view.jsp");
		
		return productHandlerAdapter;
	}

}
