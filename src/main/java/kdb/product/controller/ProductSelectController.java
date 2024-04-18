package kdb.product.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdb.product.control.Controller;
import kdb.product.dao.ProductDAO;
import kdb.product.dto.ProductDTO;
import kdb.product.hander.ProductHandlerAdapter;
import kdb.product.serviec.ProductService;

public class ProductSelectController  implements  Controller {

	@Override
	 public ProductHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		ProductDAO productDAO =new ProductDAO();
		ProductDTO productDTO = new ProductDTO();
		ArrayList<ProductDTO> arrayList = new ArrayList<ProductDTO>();
		arrayList= productDAO.productSelectAll();
		request.setAttribute("arrayList", arrayList);
		ProductHandlerAdapter productHandlerAdapter = new ProductHandlerAdapter();
		productHandlerAdapter.setPath("/WEB-INF/view/product_selct_view.jsp");
        return productHandlerAdapter;
	}

}
