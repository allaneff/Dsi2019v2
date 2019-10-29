package br.univille.dsi2019.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.dsi2019.model.TipoPagamento;

public interface TipoPagamentoRepository extends JpaRepository<TipoPagamento, Long> {

	TipoPagamento findByTipoPagamento(String tipoPagamento);
	
}

