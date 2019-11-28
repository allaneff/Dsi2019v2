package br.univille.dsi2019.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.dsi2019.model.OrdemDeServico;
import br.univille.dsi2019.repository.OrdemDeServicoRepository;
import br.univille.dsi2019.service.OrdemDeServicoService;

@Service
public class OrdemDeServicoServiceImp implements OrdemDeServicoService {

	@Autowired
	private OrdemDeServicoRepository repository;
	@Override
	public List<OrdemDeServico> getAll() {
		return repository.findAll();
	}

	@Override
	public void save(OrdemDeServico ordemDeServico) {
		repository.save(ordemDeServico);		
	}

	@Override
	public void delete(OrdemDeServico ordemDeServico) {
		repository.delete(ordemDeServico);		
	}
	
}
