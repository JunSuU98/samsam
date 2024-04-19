package ji.img.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ji.img.control.ImgController;
import ji.img.dao.ImgDAO;
import ji.img.dto.ImgDTO;
import ji.img.handler.ImgHandlerAdapter;

public class ImgUpdateViewController implements ImgController{
	private static Log log = LogFactory.getLog(ImgUpdateViewController.class);
	@Override
	public ImgHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int img_number = Integer.parseInt(request.getParameter("img_number"));
		log.info(img_number);
		
		String img_upload = request.getParameter("img_upload");
		log.info(img_upload);
		
		String img_update = request.getParameter("img_update");
		log.info(img_update);
		
		String img_url = request.getParameter("img_url");
		log.info(img_url);
		
		ImgDAO imgDao = new ImgDAO();
		ImgDTO imgDTO = new ImgDTO();
		
		imgDTO.setImg_number(img_number);
		imgDTO.setImg_upload(img_upload);
		imgDTO.setImg_update(img_update);
		imgDTO.setImg_url(img_url);
		
		imgDTO = imgDao.imgUpdate(imgDTO);
		log.info(imgDTO);
		
		request.setAttribute("imgDTO", imgDTO);
		ImgHandlerAdapter imgHandlerAdapter = new ImgHandlerAdapter();
		
		imgHandlerAdapter.setPath("./image/img_update_view.jsp");
		return imgHandlerAdapter;
	}

}
