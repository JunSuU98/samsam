package ji.img.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import ji.img.control.ImgController;
import ji.img.dao.ImgDAO;
import ji.img.dto.ImgDTO;
import ji.img.handler.ImgHandlerAdapter;

public class ImgUpdateViewController implements ImgController{
	private static Log log = LogFactory.getLog(ImgUpdateViewController.class);
	@Override
	public ImgHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
    	String path = ("C:\\samsamimg");
    	int size = 10 * 1024 * 1024;
        
    	MultipartRequest multipartRequest = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
    	
    	int img_number = Integer.parseInt(multipartRequest.getParameter("img_number"));
    	String img_update = multipartRequest.getParameter("img_update");
    	
    	Enumeration<?> enumeration = multipartRequest.getFileNames();
    	
    	String file = (String) enumeration.nextElement();
    	String filename = multipartRequest.getFilesystemName(file);
    	
    	String img_url = filename;
    
    	System.out.println("img update - "+img_update);
    	System.out.println("img url - " + img_url);
    	
        ImgDAO imgDao = new ImgDAO();
        ImgDTO imgDTO = new ImgDTO();

        imgDTO.setImg_number(img_number);
        imgDTO.setImg_update(img_update);
        imgDTO.setImg_url(img_url);

        imgDTO = imgDao.imgUpdate(imgDTO);
        log.info(imgDTO);
        request.setAttribute("imgDTO", imgDTO);
        log.info("이미지 수정");
		
        ImgHandlerAdapter imgHandlerAdapter = new ImgHandlerAdapter();
		imgHandlerAdapter.setPath("WEB-INF/view/image/img_update_view.jsp");
		
		return imgHandlerAdapter;
	}

}
