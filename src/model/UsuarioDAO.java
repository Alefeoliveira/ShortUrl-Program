package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entities.Usuario;

/*
 * Classe responsavel por receber/enviar/atualizar e deletar informações do usuario.
 * */
public class UsuarioDAO extends ConnectionDAO{
	
	ConnectionDAO dao = new ConnectionDAO();
	
	private String getUsuarioByEmail = "select * from tb_usuario where email = ?";
	private String getUsuarioByid = "select * from tb_usuario where id = ?";
	
	private Connection con;
	
	//Busca um usuario do banco de dados passando o email como parametro para a busca
	public Usuario getUsuarioByEmail(String email) {
		Usuario user = null;
		try {
			con = dao.getConnection();
			PreparedStatement ps = con.prepareStatement(getUsuarioByEmail);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user = new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("senha"));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return user;
	}
	
	//Busca um usuario do banco de dados passando o id como parametro para a busca
	public Usuario getUsuarioById(Integer id) {
		Usuario user = null;
		try {
			con = dao.getConnection();
			PreparedStatement ps = con.prepareStatement(getUsuarioByid);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user = new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("senha"));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return user;
	}
	
}
