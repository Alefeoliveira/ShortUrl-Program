package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Usuario;
import model.UsuarioDAO;

/*
 * Servlet que recebe as requisições da view index.jsp e processa as mesmas.
 * */
@WebServlet(urlPatterns = { "/LoginController", "/tabela" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UsuarioDAO dao = new UsuarioDAO();
	Usuario user;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requestLogin(request, response);
	}
	
	//Faz a verificação e autenticação do usuario.
	protected void requestLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		user = dao.getUsuarioByEmail(email);
		
		boolean sucesso = false;

		if (user != null && user.getSenha().equals(senha)) {
			request.getSession().setAttribute("logado", user);
			sucesso = true;
		}

		if (sucesso) {
			request.getRequestDispatcher("tabela.jsp").forward(request, response);
		} else {
			request.getSession().invalidate();
			request.setAttribute("Erro", senha);
			request.getRequestDispatcher("index.jsp").forward(request, response);	
		}
		
		request.getSession().invalidate();
	}

}
