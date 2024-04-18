package hong.cs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hong.cs.control.CSController;
import hong.cs.dao.CSDAO;
import hong.cs.dto.CSDTO;
import hong.cs.handler.CSHandlerAdapter;

public class CSUpdateViewController implements CSController {
	private static Log log = LogFactory.getLog(CSUpdateViewController.class);

	@Override
	public CSHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int cs_number = Integer.parseInt(request.getParameter("cs_number"));
		log.info(cs_number);
		System.out.println(cs_number);

		CSDAO csDAO = new CSDAO();
		CSDTO csDTO = new CSDTO();
		
		
		csDTO = csDAO.csSelectDetail(cs_number);
	

		request.setAttribute("csDTO", csDTO);
		CSHandlerAdapter csHandlerAdapter = new CSHandlerAdapter();
		log.info("특정 문의 조회");
		csHandlerAdapter.setPath("/WEB-INF/cs_view/cs_update_view.jsp");
		return csHandlerAdapter;
	}

}
