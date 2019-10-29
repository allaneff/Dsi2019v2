package br.univille.dsi2019.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.dsi2019.model.TipoProfissional;

public interface TipoProfissionalRepository extends JpaRepository<TipoProfissional, Long> {
	
	TipoProfissional findBynomeTipoProfissional(String nomeTipoProfissional);
}
