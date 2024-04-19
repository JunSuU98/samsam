package ji.img.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import ji.img.control.ImgController;
import ji.img.dao.ImgDAO;
import ji.img.dto.ImgDTO;
import ji.img.handler.ImgHandlerAdapter;

public class ImgInsertController implements ImgController {
    private static Log log = LogFactory.getLog(ImgInsertController.class);

    @Override
    public ImgHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 이미지 번호를 사용자로부터 입력받지 않고 시퀀스로 생성되도록 수정
        //int img_number = 0; // 시퀀스로 생성했으니까 쓸 필요 없음

    	String path = request.getSession().getServletContext().getRealPath("./upload");
    	int size = 10 * 1024 * 1024;
        
    	MultipartRequest multipartRequest = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
    	
    	String img_upload = multipartRequest.getParameter("img_upload");
    	String img_update = multipartRequest.getParameter("img_update");
    	
    	Enumeration<?> enumeration = multipartRequest.getFileNames();
    	
    	String file = (String) enumeration.nextElement();
    	String filename = multipartRequest.getFilesystemName(file);
    	
    	String img_url = path + filename;
    	
    	System.out.println("img upload - " + img_upload);
    	System.out.println("img update - "+img_update);
    	System.out.println("img url - " + img_url);
    	
//        String teString = request.getParameter("test_value");
//        System.out.println("test date - " + teString);
//        
//        String other_form = request.getParameter("other_form");
//        System.out.println("other form - " + other_form);
//        
//        String img_upload = request.getParameter("img_upload");
//        System.out.println(img_upload);
//        log.info(img_upload);
//        
//        Part img_upload_partString = request.getPart("img_upload");
//        System.out.println("img upload part" + img_upload_partString);
//
//        String img_update = request.getParameter("img_update");
//        System.out.println(img_update);
//        log.info(img_update);
//
//        String img_url = request.getParameter("img_url");
//        log.info(img_url);

        ImgDAO imgDao = new ImgDAO();
        ImgDTO imgDTO = new ImgDTO();
        ArrayList<ImgDTO> arrayList = new ArrayList<ImgDTO>();

        arrayList = imgDao.imgSelectAll();
        log.info(arrayList);
        request.setAttribute("arrayList", arrayList);

        //imgDTO.setImg_number(img_number);
        imgDTO.setImg_upload(img_upload);
        imgDTO.setImg_update(img_update);
        imgDTO.setImg_url(img_url);

        imgDTO = imgDao.imgInsert(imgDTO);
        log.info(imgDTO);
        request.setAttribute("imgDTO", imgDTO);
        log.info("이미지 정보 등록");

        ImgHandlerAdapter imgHandlerAdapter = new ImgHandlerAdapter();

        imgHandlerAdapter.setPath("./image/img_insert_view.jsp");

        return imgHandlerAdapter;
    }

}
