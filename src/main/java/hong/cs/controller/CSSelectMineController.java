package hong.cs.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hong.cs.control.CSController;
import hong.cs.dao.CSDAO;
import hong.cs.dto.CSDTO;
import hong.cs.handler.CSHandlerAdapter;

public class CSSelectMineController implements CSController {

	@Override
	public CSHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {

		int member_number = Integer.parseInt(request.getParameter("member_number"));
		
		ArrayList<CSDTO> arrayList = new ArrayList<CSDTO>();
		
		CSDAO csdao = new CSDAO();
		
		arrayList = csdao.csSelectMine(member_number);
		
		request.setAttribute("arrayList", arrayList);
		
		CSHandlerAdapter csHandlerAdapter = new CSHandlerAdapter();
		csHandlerAdapter.setPath("/WEB-INF/view/cs_view/cs_select_mine.jsp");
		
		return csHandlerAdapter;
	}

}
