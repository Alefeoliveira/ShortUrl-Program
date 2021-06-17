package view;

import java.util.List;

import entities.Urls;
import model.LinkUrlDAO;

/*
 * Renderiza os links na view tabela.jsp.
 * */
public class LinkUrlView {
	
	//Recebe todos os links cadastrados e insere em uma lista e retorna a mesma para a view.
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
	
	//Recebe o link atraves da url encurtada (utilizado na view para o redirecionamento).
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
