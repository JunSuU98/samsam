package kdb.product.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdb.product.hander.ProductHandlerAdapter;

public interface Controller {
	public ProductHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response);
}
