package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Usuario;
import model.LinkUrlDAO;
import model.UsuarioDAO;

@WebServlet(urlPatterns = { "/Controller", "/tabela" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UsuarioDAO dao = new UsuarioDAO();
	Usuario user;
	
	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		user = dao.getUsuarioByEmail(email);
		
		boolean sucesso = false;

		if (user != null && user.getSenha().equals(senha)) {
			sucesso = true;
		}

		if (sucesso) {
			response.sendRedirect("tabela.jsp");
		} else {
			response.sendRedirect("index.jsp");
		}
	}

}
