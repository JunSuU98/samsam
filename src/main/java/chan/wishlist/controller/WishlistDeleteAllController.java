package chan.wishlist.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import chan.wishlist.control.Controller;
import chan.wishlist.dao.WishlistDAO;
import chan.wishlist.dto.WishlistDTO;
import chan.wishlist.hander.HandlerAdapter;

public class WishlistDeleteAllController implements Controller {
    private static final Log log = LogFactory.getLog(WishlistDeleteAllController.class);
    

    @Override
    public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
        log.info("WishlistDeleteAllController 실행");
        WishlistDTO wishlistDTO = new WishlistDTO();     
        int member_number = Integer.parseInt(request.getParameter("member_number"));
        wishlistDTO.setMember_number(member_number);

        WishlistDAO wishlistDAO = new WishlistDAO();
        wishlistDAO.wishlistDeleteAll(wishlistDTO);

        HandlerAdapter handlerAdapter = new HandlerAdapter();
        handlerAdapter.setPath("/WishlistSelect.wi");
        
        return handlerAdapter;
    }
}