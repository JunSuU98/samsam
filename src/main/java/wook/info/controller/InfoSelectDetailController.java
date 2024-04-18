package wook.info.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import wook.info.control.Controller;
import wook.info.dao.InfoDAO;
import wook.info.dto.InfoDTO;
import wook.info.hander.InfoHandlerAdapter;

public class InfoSelectDetailController implements Controller{
	private static Log log = LogFactory.getLog(InfoSelectDetailController.class);
	
  @Override
public InfoHandlerAdapter excute(HttpServletRequest request, HttpServletResponse response) {
	   int info_Number=Integer.parseInt(request.getParameter("info_Number"));

	    
		InfoDAO infoDAO = new InfoDAO();
		InfoDTO infoDTO = new InfoDTO();
		infoDTO=infoDAO.infoSelectDetail(info_Number);
		log.info(infoDTO);
		request.setAttribute("infoDTO", infoDTO);
	    InfoHandlerAdapter infoHandlerAdapter = new InfoHandlerAdapter();
	    infoHandlerAdapter.setPath("/view/info/info_selectDetail_view.jsp");
	return infoHandlerAdapter;
}
}
