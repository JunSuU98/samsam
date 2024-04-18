package wook.info.controller;

import java.util.ArrayList;
import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import wook.info.control.Controller;
import wook.info.dao.InfoDAO;
import wook.info.dto.InfoDTO;
import wook.info.hander.InfoHandlerAdapter;

public class InfoInsertController implements Controller {
	private static Log log= LogFactory.getLog(InfoInsertController.class);
 @Override
public InfoHandlerAdapter excute(HttpServletRequest request, HttpServletResponse response) {
	 String info_Title=request.getParameter("info_Title");
	 log.info(info_Title);
	 String info_Content=request.getParameter("info_Content");
	 log.info(info_Content);
	 String info_Date=request.getParameter("info_Date");
	 log.info(info_Date);
	 InfoDAO infoDAO = new InfoDAO();
	 InfoDTO infoDTO = new InfoDTO();
	 ArrayList<InfoDTO> arraylist = new ArrayList<InfoDTO>();
	 arraylist =infoDAO.infoSelect();
	 request.setAttribute("arrayList", arraylist);
	 infoDTO.setInfo_Title(info_Title);
	 infoDTO.setInfo_Content(info_Content);
	 infoDTO.setInfo_Date(info_Date);
	 infoDTO= infoDAO.infoInsert(infoDTO);
	 request.setAttribute("infoDTO", infoDTO);
	 InfoHandlerAdapter infoHandlerAdapter = new InfoHandlerAdapter();
	 infoHandlerAdapter.setPath("/view/info/info_insert_view.jsp");
	 log.info(infoDTO);
	 
	 
	 
	return infoHandlerAdapter;
}
}
