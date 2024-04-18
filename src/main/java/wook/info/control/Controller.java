package wook.info.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wook.info.hander.InfoHandlerAdapter;

public interface Controller {
  
	   
	   
	   public InfoHandlerAdapter excute(HttpServletRequest request, HttpServletResponse response); 
		
	
   }

