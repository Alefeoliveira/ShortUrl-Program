package view;

import entities.Usuario;
import model.UsuarioDAO;

/*
 * Renderiza o usuario na view atraves de um metodo que passa o email como parametro.
 * */
public class UsuarioView {
	
	public Usuario getUsuarioByEmail(String email) {
		Usuario user = null;
		try {
			UsuarioDAO dao = new UsuarioDAO();
			user = dao.getUsuarioByEmail(email);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return user;
	}

}
