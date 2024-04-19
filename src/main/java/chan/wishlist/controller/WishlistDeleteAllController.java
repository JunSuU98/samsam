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
        WishlistDAO wishlistDAO = new WishlistDAO();
        wishlistDTO = wishlistDAO.wishlistDeleteAll(wishlistDTO);
        try {
            PrintWriter out = response.getWriter();
            if (wishlistDTO.getProduct_title() != null) {
                out.print("{\"exists\": false}");
            } else {
                out.print("{\"exists\": true}");
            }
            out.flush();
        } catch (IOException e) {
            log.error("응답 데이터 작성 실패", e);
        }
        return null;
    }
}