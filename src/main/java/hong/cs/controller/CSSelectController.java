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

public class CSSelectController implements CSController {
	private static Log log=LogFactory.getLog(CSSelectController.class);

	@Override
	public CSHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		CSDAO csDAO = new CSDAO();
		CSDTO csDTO = new CSDTO();
		log.info(csDTO);
		ArrayList<CSDTO> arrayList = new ArrayList<CSDTO>();
		
		arrayList=csDAO.csSelect();
		log.info(arrayList);
		request.setAttribute("arrayList", arrayList);
		CSHandlerAdapter csHandlerAdapter = new CSHandlerAdapter();
		log.info("고객 문의 조회");
		
		csHandlerAdapter.setPath("/WEB-INF/cs_view/cs_select_view.jsp");
		return csHandlerAdapter;
	}
}