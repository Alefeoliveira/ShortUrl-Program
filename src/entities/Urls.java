package entities;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Urls {
	
	private Integer id;
	private String url;
	private String url_encurtada;
	private Date data_url;
	private Integer codigo_usuario;
	
	public Urls() {
		super();
	}
	
	public Urls(Integer id, String url, String url_encurtada, Date data_url, Integer codigo_usuario) {
		super();
		this.id = id;
		this.url = url;
		this.url_encurtada = url_encurtada;
		this.data_url = data_url;
		this.codigo_usuario = codigo_usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl_encurtada() {
		return url_encurtada;
	}

	public void setUrl_encurtada(String url_encurtada) {
		this.url_encurtada = url_encurtada;
	}

	public Date getData_url() {
		return data_url;
	}

	public void setData_url(Date data_url) {
		this.data_url = data_url;
	}

	public Integer getCodigo_usuario() {
		return codigo_usuario;
	}

	public void setCodigo_usuario(Integer codigo_usuario) {
		this.codigo_usuario = codigo_usuario;
	}
	
	

	
}
