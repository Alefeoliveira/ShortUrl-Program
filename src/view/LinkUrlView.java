package view;

import java.util.List;

import entities.Urls;
import model.LinkUrlDAO;

public class LinkUrlView {
	
	public List<Urls> getLinksUrls() {
		List<Urls> lista = null;
		try {
			LinkUrlDAO urlDAO = new LinkUrlDAO();
			lista = urlDAO.findAllUrls();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	public Urls getLinkByUrlEncurtada(String url_encurtada) {
		Urls urls = null;
		try {
			LinkUrlDAO urlDAO = new LinkUrlDAO();
			urls = urlDAO.getLinkByUrlEncurtada(url_encurtada);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return urls;
	}

}
