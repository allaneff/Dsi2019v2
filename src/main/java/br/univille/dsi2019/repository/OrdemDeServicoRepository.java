package br.univille.dsi2019.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.dsi2019.model.OrdemDeServico;

public interface OrdemDeServicoRepository extends JpaRepository<OrdemDeServico, Long>{
	
	OrdemDeServico findById(long id);
}
