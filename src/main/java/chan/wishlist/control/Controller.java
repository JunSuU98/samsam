package chan.wishlist.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chan.wishlist.hander.HandlerAdapter;

public interface Controller {
public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response);
}
