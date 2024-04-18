package hong.cs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hong.cs.control.CSController;
import hong.cs.dao.CSDAO;
import hong.cs.dto.CSDTO;
import hong.cs.handler.CSHandlerAdapter;

public class CSDeleteContorller implements CSController {
	private static Log log=LogFactory.getLog(CSDeleteContorller.class);

	@Override
	public CSHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int cs_number=Integer.parseInt(request.getParameter("cs_number"));
		log.info(cs_number);
		
		CSDAO csDAO = new CSDAO();
		CSDTO csDTO = new CSDTO();
		
		csDTO.setCs_number(cs_number);
		
		request.setAttribute("csDTO", csDTO);
		csDTO=csDAO.csDelete(cs_number);
		log.info(csDTO);
		CSHandlerAdapter csHandlerAdapter = new CSHandlerAdapter();
		
		csHandlerAdapter.setPath("/WEB-INF/cs_view/cs_delete.jsp");
		return csHandlerAdapter;
	}
}