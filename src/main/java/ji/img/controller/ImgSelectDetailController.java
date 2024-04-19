package ji.img.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ji.img.control.ImgController;
import ji.img.dao.ImgDAO;
import ji.img.dto.ImgDTO;
import ji.img.handler.ImgHandlerAdapter;

public class ImgSelectDetailController implements ImgController {
	private static Log log = LogFactory.getLog(ImgSelectDetailController.class);
	
	@Override
	public ImgHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int img_number = Integer.parseInt(request.getParameter("img_number"));
		log.info(img_number);
		
		ImgDAO imgDao = new ImgDAO();
		ImgDTO imgDTO = new ImgDTO();
		
		imgDTO = imgDao.imgSelect(img_number);
		log.info(imgDTO);
		
		request.setAttribute("imgDTO", imgDTO);
		ImgHandlerAdapter imgHandlerAdapter = new ImgHandlerAdapter();
		log.info("특정 이미지 조회");
		
		imgHandlerAdapter.setPath("./image/img_select_detail_view.jsp");
		return imgHandlerAdapter;
	}


}
