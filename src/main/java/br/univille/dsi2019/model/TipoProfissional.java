package br.univille.dsi2019.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoProfissional {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nomeTipoProfissional;
	
	//Getters and Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomeTipoProfissional() {
		return nomeTipoProfissional;
	}
	public void setNomeTipoProfissional(String nomeTipoProfissional) {
		this.nomeTipoProfissional = nomeTipoProfissional;
	}
}
