package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import controller.Controller;
import entities.Urls;

public class LinkUrlDAO extends DAO{
	
	DAO dao = new DAO();
	
	
	public String insert = "insert into tb_urls(url, url_encurtada, data_url, codigo_usuario) values (?, (SELECT LEFT(MD5(RAND()), 8)), sysdate(), (select id from tb_usuario))";
	public String findAllUrl = "select * from tb_urls";
	public String getLinkByUrlEncurtada = "select * from tb_urls where url_encurtada = ?";
	
	public boolean insertUrl(String url) {
		try {
			Connection con = dao.getConnection();
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, url);
			return ps.execute();
		}catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}finally {
			dao.closeConnection();
		}
		
	}

	public List<Urls> findAllUrls() {
		List<Urls> urls = new ArrayList<Urls>();
		try {
			Connection con = dao.getConnection();
			PreparedStatement ps = con.prepareStatement(findAllUrl);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				urls.add(new Urls(rs.getInt("id"), rs.getString("url"), rs.getString("url_encurtada"), rs.getDate("data_url"), rs.getInt("codigo_usuario")));
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally {
			dao.closeConnection();
		}
		return urls;
	}
	
	public Urls getLinkByUrlEncurtada(String url_encurtada) {
		Urls urls = null;
		try {
			Connection con = dao.getConnection();
			PreparedStatement ps = con.prepareStatement(getLinkByUrlEncurtada);
			ps.setString(1, url_encurtada);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				urls = (new Urls(rs.getInt("id"), rs.getString("url"), rs.getString("url_encurtada"), rs.getDate("data_url"), rs.getInt("codigo_usuario")));
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally {
			dao.closeConnection();
		}
		return urls;
	}

}
