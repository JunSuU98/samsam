package kdb.product.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdb.product.control.Controller;
import kdb.product.dao.ProductDAO;
import kdb.product.dto.ProductDTO;
import kdb.product.hander.ProductHandlerAdapter;

public class ProductSelectMineController implements Controller {

	@Override
	public ProductHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {

		int member_number = Integer.parseInt(request.getParameter("member_number"));
		
		ArrayList<ProductDTO> arrayList = new ArrayList<ProductDTO>();
		
		ProductDAO productDAO = new ProductDAO();
		
		arrayList = productDAO.productSelectMine(member_number);
		
		request.setAttribute("arrayList", arrayList);
		
		ProductHandlerAdapter productHandlerAdapter = new ProductHandlerAdapter();
		productHandlerAdapter.setPath("/WEB-INF/view/product_view/product_select_mine.jsp");
		
		return productHandlerAdapter;
	}

}
