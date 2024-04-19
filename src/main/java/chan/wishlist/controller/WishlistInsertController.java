package chan.wishlist.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import chan.wishlist.control.Controller;
import chan.wishlist.dao.WishlistDAO;
import chan.wishlist.dto.WishlistDTO;
import chan.wishlist.hander.HandlerAdapter;

public class WishlistInsertController implements Controller {
private static Log log = LogFactory.getLog(WishlistInsertController.class);

@Override
public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
String product_title = request.getParameter("product_title");
log.info(product_title);
int product_number =Integer.parseInt(request.getParameter("product_number"));
log.info(product_number);
int member_number = Integer.parseInt(request.getParameter("member_number"));
log.info(member_number);
WishlistDTO wishlistDTO = new WishlistDTO();
WishlistDAO wishlistDAO = new WishlistDAO();
wishlistDTO.setProduct_title(product_title);
wishlistDTO.setProduct_number(product_number);
wishlistDTO.setMember_number(member_number);
log.info(wishlistDTO);
wishlistDTO = wishlistDAO.wishlistInsert(wishlistDTO);
HandlerAdapter handlerAdapter = new HandlerAdapter();
handlerAdapter.setPath("./wishlistindex.jsp");
return handlerAdapter;
}
}
