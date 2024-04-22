package kdb.product.controller;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdb.product.control.Controller;
import kdb.product.dao.ProductDAO;
import kdb.product.dto.ProductDTO;
import kdb.product.hander.ProductHandlerAdapter;

public class ProductImgIndexController implements Controller {

	@Override
	public ProductHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {

		ArrayList<ProductDTO> arrayList = new ArrayList<ProductDTO>();
		ProductDAO productDAO = new ProductDAO();
		
		arrayList = productDAO.productSelectImgIndex();
		System.out.println("img index arraylist - " + arrayList);
		
		 // 이미지 인덱스 값을 담을 배열
        int[] imgIndexes = new int[arrayList.size()];

        // ArrayList의 각 ProductDTO 객체에서 img_index 값을 추출하여 새 배열에 추가
        for (int i = 0; i < arrayList.size(); i++) {
            imgIndexes[i] = arrayList.get(i).getImg_index();
        }

		// JSON 으로 응답 전달
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            PrintWriter out = response.getWriter();
            out.print("[");
            for (int i = 0; i < imgIndexes.length; i++) {
                out.print(imgIndexes[i]);
                if (i < imgIndexes.length - 1) {
                    out.print(", ");
                }
            }
            out.print("]");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	
		return null;
	}

}
