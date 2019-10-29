package br.univille.dsi2019.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.dsi2019.model.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long>{
	
	Profissional findBynomeProfissional(String nomeProfissional);

}