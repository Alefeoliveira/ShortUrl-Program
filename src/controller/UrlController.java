package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LinkUrlDAO;


@WebServlet("/UrlController")
public class UrlController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UrlController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		try {
			LinkUrlDAO links = new LinkUrlDAO();
			if(!links.insertUrl(request.getParameter("url"))) {
				throw new Exception("não foi possisel pegar a url");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		request.getRequestDispatcher("tabela.jsp").forward(request, response);
	}

}
