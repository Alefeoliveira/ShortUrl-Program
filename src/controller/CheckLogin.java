package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckLogin {
	
	protected void isLogged(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getSession().getAttribute("logado") == null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);	
		}
		
	}
}
