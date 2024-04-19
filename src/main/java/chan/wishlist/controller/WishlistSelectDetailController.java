package chan.wishlist.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import chan.wishlist.control.Controller;
import chan.wishlist.dao.WishlistDAO;
import chan.wishlist.dto.WishlistDTO;
import chan.wishlist.hander.HandlerAdapter;

public class WishlistSelectDetailController implements Controller{
private static final Log log = LogFactory.getLog(WishlistSelectDetailController.class);
@Override
public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
	int wishlist_number = Integer.parseInt(request.getParameter("wishlist_number"));
	log.info(wishlist_number);
	WishlistDTO wishlistDTO = new WishlistDTO();
	wishlistDTO.setWishlist_number(wishlist_number);
	WishlistDAO wishlistDAO = new WishlistDAO();
	wishlistDTO = wishlistDAO.wishlistSelect(wishlistDTO);
	log.info(wishlistDTO);
	HandlerAdapter handlerAdapter = new HandlerAdapter();
	handlerAdapter.setPath("/WEB-INF/view/wishlist/wishlist_select_detail_view.jsp");
	return handlerAdapter;
}
}
