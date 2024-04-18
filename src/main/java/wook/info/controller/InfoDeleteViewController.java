package wook.info.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wook.info.control.Controller;
import wook.info.dao.InfoDAO;
import wook.info.dto.InfoDTO;
import wook.info.hander.InfoHandlerAdapter;

public class InfoDeleteViewController implements Controller {
@Override
public InfoHandlerAdapter excute(HttpServletRequest request, HttpServletResponse response) {
	
	int info_Number=Integer.parseInt(request.getParameter("info_Number"));
    String info_Title=request.getParameter("info_Number");
    String info_Content= request.getParameter("info_Content");
    String info_Date = request.getParameter("info_Date");
	InfoDAO infoDAO = new InfoDAO();
	InfoDTO infoDTO = new InfoDTO();
	infoDTO.setInfo_Number(info_Number);
	infoDTO.setInfo_Title(info_Title);
	infoDTO.setInfo_Content(info_Content);
	infoDTO.setInfo_Date(info_Date);
	infoDTO=infoDAO.infoDelete(info_Number);
	request.setAttribute("infoDTO", infoDTO);
	InfoHandlerAdapter infoHandlerAdapter = new InfoHandlerAdapter();
    infoHandlerAdapter.setPath("/WEB-INF/view/info/info_delete_view.jsp");
	return infoHandlerAdapter;


	
}
}
