	package wook.info.controller;
	
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	
	import org.apache.commons.logging.Log;
	import org.apache.commons.logging.LogFactory;
	
	import wook.info.control.Controller;
	import wook.info.dao.InfoDAO;
	import wook.info.dto.InfoDTO;
	import wook.info.hander.InfoHandlerAdapter;
	
	public class InfoDeleteController implements Controller {
		private static Log log= LogFactory.getLog(InfoDeleteController.class);
	@Override
	public InfoHandlerAdapter excute(HttpServletRequest request, HttpServletResponse response) {
		int info_Number=Integer.parseInt(request.getParameter("info_Number"));
		log.info(info_Number);
		System.out.println(info_Number);
		InfoDAO infoDAO = new InfoDAO();
		InfoDTO infoDTO = new InfoDTO();
		infoDTO=infoDAO.infoSelectDetail(info_Number);
		request.setAttribute("infoDTO", infoDTO);
		InfoHandlerAdapter infoHandlerAdapter = new InfoHandlerAdapter();
		log.info("삭제 전 데이터 조회");
	    infoHandlerAdapter.setPath("/WEB-INF/view/info/info_delete.jsp");
		return infoHandlerAdapter;
	}
	}
