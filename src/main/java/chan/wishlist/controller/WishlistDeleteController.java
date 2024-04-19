package chan.wishlist.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import chan.wishlist.control.Controller;
import chan.wishlist.dao.WishlistDAO;
import chan.wishlist.dto.WishlistDTO;
import chan.wishlist.hander.HandlerAdapter;

public class WishlistDeleteController implements Controller {
private static final Log log = LogFactory.getLog(WishlistDeleteController.class);

@Override
public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
	log.info("WishlistDeleteController 실행");
	int wishlist_number = Integer.parseInt(request.getParameter("wishlist_number"));
	log.info(wishlist_number);
	WishlistDTO wishlistDTO = new WishlistDTO();
	wishlistDTO.setWishlist_number(wishlist_number);
	WishlistDAO wishlistDAO = new WishlistDAO();
	wishlistDTO = wishlistDAO.wishlistDelete(wishlistDTO);
	log.info(wishlistDTO);
	request.setAttribute("wishlistDTO", wishlistDTO);
	HandlerAdapter handlerAdapter = new HandlerAdapter();
	handlerAdapter.setPath("/WEB-INF/view/wishlist/wishlist_delete_view.jsp");
	return handlerAdapter;
}

}
