	package wook.info.controller;
	
	import java.util.ArrayList;
	
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	
	import wook.info.control.Controller;
	import wook.info.dao.InfoDAO;
	import wook.info.dto.InfoDTO;
	import wook.info.hander.InfoHandlerAdapter;
	
	public class InfoSelectController implements Controller {
	
		@Override
		public InfoHandlerAdapter excute(HttpServletRequest request, HttpServletResponse response) {
		    InfoDTO infoDTO = new InfoDTO();
		    InfoDAO infoDAO = new InfoDAO();
		    ArrayList<InfoDTO> arraylist = new ArrayList<InfoDTO>();
		    arraylist= infoDAO.infoSelect();
		    request.setAttribute("arraylist", arraylist);
		    InfoHandlerAdapter infoHandlerAdapter = new InfoHandlerAdapter();
		    infoHandlerAdapter.setPath("/view/info/info_select_view.jsp");
			return infoHandlerAdapter;
		}
	
	}
