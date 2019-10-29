package br.univille.dsi2019.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.dsi2019.model.LocalServico;

public interface LocalServicoRepository extends JpaRepository<LocalServico, Long>{
	
	LocalServico findBynomeLocal(String nomeLocal );
}
