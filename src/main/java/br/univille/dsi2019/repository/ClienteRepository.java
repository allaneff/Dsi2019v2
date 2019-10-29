package br.univille.dsi2019.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.dsi2019.model.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	Cliente findBynomeCliente(String nomeCliente);

}
