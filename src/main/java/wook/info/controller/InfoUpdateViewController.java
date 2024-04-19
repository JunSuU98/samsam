package wook.info.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import wook.info.control.Controller;
import wook.info.dao.InfoDAO;
import wook.info.dto.InfoDTO;
import wook.info.hander.InfoHandlerAdapter;

public class InfoUpdateViewController implements Controller{
	private static Log log= LogFactory.getLog(InfoUpdateViewController.class);
@Override
public InfoHandlerAdapter excute(HttpServletRequest request, HttpServletResponse response) {
	int info_Number=Integer.parseInt(request.getParameter("info_Number"));
    String info_Title=request.getParameter("info_Title");
    String info_Content= request.getParameter("info_Content");
    String info_Date = request.getParameter("info_Date");
	log.info(info_Number);
	log.info(info_Date);
	log.info(info_Content);
	log.info(info_Title);
	InfoDAO infoDAO = new InfoDAO();
	InfoDTO infoDTO = new InfoDTO();
	infoDTO.setInfo_Number(info_Number);
	infoDTO.setInfo_Title(info_Title);
	infoDTO.setInfo_Content(info_Content);
	infoDTO.setInfo_Date(info_Date);
	infoDTO=infoDAO.infoUpdate(infoDTO);
	request.setAttribute("infoDTO", infoDTO);
	InfoHandlerAdapter infoHandlerAdapter = new InfoHandlerAdapter();
	log.info("수정 전 데이터 조회");
    infoHandlerAdapter.setPath("/WEB-INF/view/info/info_update_view.jsp");
	return infoHandlerAdapter;
}
}
