package ji.img.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ji.img.control.ImgController;
import ji.img.handler.ImgHandlerAdapter;

public class ImgViewController implements ImgController {

	@Override
	public ImgHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		System.out.println("ImgViewController 실행");
		
		String img_url = request.getParameter("img_url");
		System.out.println("img_url - " + img_url);
		
		String img_path = "C:\\\\samsamimg\\" + img_url;
		System.out.println("img_path - " + img_path);
		
		File imageFile = new File(img_path);
		byte[] imageData = new byte[(int) imageFile.length()];
		FileInputStream fis = new FileInputStream(imageFile);
		
		fis.read(imageData);
		fis.close();
		
		response.setContentType("image/png");
		response.setContentLength(imageData.length);

		OutputStream os = response.getOutputStream();
		os.write(imageData);
		os.flush();
		os.close();
	
		
		return null;
	}

}
