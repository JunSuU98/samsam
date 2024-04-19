package ji.img.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ji.img.control.ImgController;
import ji.img.dao.ImgDAO;
import ji.img.dto.ImgDTO;
import ji.img.handler.ImgHandlerAdapter;

public class ImgDeleteController implements ImgController {
	private static Log log = LogFactory.getLog(ImgDeleteController.class);

	@Override
	public ImgHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int img_number = Integer.parseInt(request.getParameter("img_number"));
		log.info(img_number);
		
		ImgDAO imgDao = new ImgDAO();
		ImgDTO imgDTO = new ImgDTO();
		
		imgDTO.setImg_number(img_number);
		
		request.setAttribute("imgDTO", imgDTO);
		
		imgDTO = imgDao.imgDelete(img_number);
		log.info(imgDTO);
		ImgHandlerAdapter imgHandlerAdapter = new ImgHandlerAdapter();
		
		imgHandlerAdapter.setPath("./image/img_delete_view.jsp");
		return imgHandlerAdapter;
	}

}
