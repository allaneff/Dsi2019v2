package br.univille.dsi2019.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.dsi2019.model.TipoServico;

public interface TipoServicoRepository extends JpaRepository<TipoServico, Long> {

	TipoServico findBynomeTipoServico(String nomeTipoServico);
	
}
