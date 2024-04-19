package hong.cs.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hong.cs.control.CSController;
import hong.cs.dao.CSDAO;
import hong.cs.dto.CSDTO;
import hong.cs.handler.CSHandlerAdapter;

public class CSInsertController implements CSController {
	private static Log log = LogFactory.getLog(CSInsertController.class);

	@Override
	public CSHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		String cs_title = request.getParameter("cs_title");
		log.info(cs_title);
		String cs_date = request.getParameter("cs_date");
		log.info(cs_date);
		String cs_content = request.getParameter("cs_content");
		log.info(cs_content);

		CSDAO csDAO = new CSDAO();
		CSDTO csDTO = new CSDTO();
		ArrayList<CSDTO> arrayList = new ArrayList<CSDTO>();
		
		arrayList=csDAO.csSelect();
		log.info(arrayList);
		request.setAttribute("arrayList", arrayList);
		
		csDTO.setCs_title(cs_title);
		csDTO.setCs_date(cs_date);
		csDTO.setCs_content(cs_content);

		csDTO = csDAO.csInsert(csDTO);
		log.info(csDTO);
		request.setAttribute("csDTO", csDTO);
		log.info("문의 정보 등록");
		CSHandlerAdapter csHandlerAdapter = new CSHandlerAdapter();

		csHandlerAdapter.setPath("/WEB-INF/view/cs_view/cs_insert.jsp");
		return csHandlerAdapter;
	}
}