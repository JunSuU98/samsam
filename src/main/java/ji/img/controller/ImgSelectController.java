package ji.img.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ji.img.control.ImgController;
import ji.img.dao.ImgDAO;
import ji.img.dto.ImgDTO;
import ji.img.handler.ImgHandlerAdapter;

public class ImgSelectController implements ImgController{
	private static Log log = LogFactory.getLog(ImgSelectController.class);
	
	@Override
	public ImgHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		ImgDAO imgDao = new ImgDAO();
		ImgDTO imgDTO = new ImgDTO();
		log.info(imgDTO);
		ArrayList<ImgDTO> arrayList = new ArrayList<ImgDTO>();
		
		arrayList = imgDao.imgSelectAll();
		request.setAttribute("arrayList", arrayList);
		log.info(arrayList);
		
		ImgHandlerAdapter imgHandlerAdapter = new ImgHandlerAdapter();
		log.info("이미지 정보 조회");
		
		imgHandlerAdapter.setPath("./image/img_select.jsp");
		return imgHandlerAdapter;
	}

}
