package br.univille.dsi2019.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.dsi2019.model.TipoServico;
import br.univille.dsi2019.repository.TipoServicoRepository;
import br.univille.dsi2019.service.TipoServicoService;
@Service
public class TipoServicoServiceImpl implements TipoServicoService{

	@Autowired
	private TipoServicoRepository repository;
	
	@Override
	public List<TipoServico> getAll() {
		return repository.findAll();
	}

	@Override
	public void save(TipoServico tipoServico) {
		repository.save(tipoServico);
		
	}

	@Override
	public void delete(TipoServico tipoServico) {
		repository.delete(tipoServico);
		
	}

	
}
