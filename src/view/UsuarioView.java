package view;

import entities.Usuario;
import model.UsuarioDAO;

public class UsuarioView {
	
	public Usuario getUsuarioById(Integer id) {
		Usuario user = null;
		try {
			UsuarioDAO dao = new UsuarioDAO();
			user = dao.getUsuarioById(id);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return user;
	}

}
