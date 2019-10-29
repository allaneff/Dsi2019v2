package br.univille.dsi2019.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LocalServico {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nomeLocal;
	private String detalhesLocal;
	private String enderecoLocal;
	private Boolean statusLocal;
	
	//Getters and Setters 
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomeLocal() {
		return nomeLocal;
	}
	public void setNomeLocal(String nomeLocal) {
		this.nomeLocal = nomeLocal;
	}
	public String getDetalhesLocal() {
		return detalhesLocal;
	}
	public void setDetalhesLocal(String detalhesLocal) {
		this.detalhesLocal = detalhesLocal;
	}
	public String getEnderecoLocal() {
		return enderecoLocal;
	}
	public void setEnderecoLocal(String enderecoLocal) {
		this.enderecoLocal = enderecoLocal;
	}
	public Boolean getStatusLocal() {
		return statusLocal;
	}
	public void setStatusLocal(Boolean statusLocal) {
		this.statusLocal = statusLocal;
	}
	
}
