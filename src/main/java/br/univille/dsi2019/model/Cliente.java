package br.univille.dsi2019.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;




@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(length=800)
	@NotNull
	private String nomeCliente;
	@NotNull
	private String cpf;
	@Column(length=800)
	@NotNull
	private String email;
	@Column(length=50)
	@NotNull
	@Length(min=2, max=8, message="O tamanho da senha deve ser entre {min} e {max}")
	private String senha;
	@Column(length=800)
	@NotNull
	private String endereco;
	@NotNull
	private String telefone;
	@Column(length=1200)
	private String observacoes;
	@NotNull
	private boolean status;
	
	//@javax.persistence.Temporalporal(value=TemporalType.TIMESTAMP)
	//private Date dataCadastro;
	
	//Getters and Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(@NotNull String telefone) {
		this.telefone = telefone;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
