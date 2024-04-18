package kdb.product.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdb.product.control.Controller;
import kdb.product.dao.ProductDAO;
import kdb.product.dto.ProductDTO;
import kdb.product.hander.ProductHandlerAdapter;
import org.apache.commons.logging.*;
public class ProductInsertController implements Controller {
	private static Log log = LogFactory.getLog(ProductInsertController.class);
	@Override
	public ProductHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		//int product_number =Integer.parseInt(request.getParameter("product_number"));
		//log.info(product_number);
		String product_upload=request.getParameter("product_upload");
		log.info(product_upload);
		String product_update = request.getParameter("product_update");
		log.info(product_update);
		String product_title=request.getParameter("product_title");
		log.info(product_title);
		int product_price=Integer.parseInt(request.getParameter("product_price"));
		log.info(product_price);
		String product_content =request.getParameter("product_content");
		log.info(product_content);
		String product_status = request.getParameter("product_status");
		ProductDAO productDAO= new ProductDAO();
		ProductDTO productDTO= new ProductDTO();
		ArrayList<ProductDTO> arrayList = new ArrayList<ProductDTO>();
		arrayList=productDAO.productSelectAll();
		log.info(arrayList);
		request.setAttribute("arrayList", arrayList);
		//productDTO.setProduct_number(product_number);
		productDTO.setProduct_upload(product_upload);
		productDTO.setProduct_update(product_update);
		productDTO.setProduct_title(product_title);
		productDTO.setProduct_price(product_price);
		productDTO.setProduct_content(product_content);
		productDTO.setProduct_status(product_status);
		productDTO =productDAO.productInsert(productDTO);
		request.setAttribute("productDTO", productDTO);
		ProductHandlerAdapter productHandlerAdapter =new ProductHandlerAdapter();
		productHandlerAdapter.setPath("/WEB-INF/view/product_insert_view.jsp");
		return productHandlerAdapter;
	}
}
