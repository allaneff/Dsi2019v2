package br.univille.dsi2019.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrdemDeServico {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@ManyToOne(cascade= {CascadeType.MERGE, CascadeType.REFRESH},optional=false)
	private Cliente cliente;
	@ManyToOne(cascade= {CascadeType.MERGE, CascadeType.REFRESH},optional=false)
	private Profissional profissional;
	private float valor;
	@ManyToOne(cascade= {CascadeType.MERGE, CascadeType.REFRESH},optional=false)
	private TipoPagamento tipoPagamento;
	@ManyToOne(cascade= {CascadeType.MERGE, CascadeType.REFRESH},optional=false)
	private TipoServico tiposervico;
	private Boolean status;
	private String local;
	private Date dataInicio;
	private Date dataFim;
	
	
	//Getters and Setters
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Profissional getProfissional() {
		return profissional;
	}
	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	public TipoServico getTiposervico() {
		return tiposervico;
	}
	public void setTiposervico(TipoServico tiposervico) {
		this.tiposervico = tiposervico;
	}
	
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
}
