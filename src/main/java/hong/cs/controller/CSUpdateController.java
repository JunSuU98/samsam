package hong.cs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hong.cs.control.CSController;
import hong.cs.dao.CSDAO;
import hong.cs.dto.CSDTO;
import hong.cs.handler.CSHandlerAdapter;

public class CSUpdateController implements CSController {
	private static Log log=LogFactory.getLog(CSUpdateController.class);

	@Override
	public CSHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int cs_number=Integer.parseInt(request.getParameter("cs_number"));
		log.info(cs_number);
		String cs_title=request.getParameter("cs_title");
		log.info(cs_title);
		String cs_date=request.getParameter("cs_date");
		log.info(cs_date);
		String cs_content=request.getParameter("cs_content");
		log.info(cs_content);
		
		CSDAO csDAO = new CSDAO();
		CSDTO csDTO = new CSDTO();
		
		csDTO.setCs_number(cs_number);
		csDTO.setCs_title(cs_title);
		csDTO.setCs_date(cs_date);
		csDTO.setCs_content(cs_content);
		
		csDTO=csDAO.csUpdate(csDTO);
		log.info(csDTO);
		
		request.setAttribute("csDTO", csDTO);
		CSHandlerAdapter csHandlerAdapter = new CSHandlerAdapter();
		csHandlerAdapter.setPath("/WEB-INF/cs_view/cs_update.jsp");
		return csHandlerAdapter;
	}
}
