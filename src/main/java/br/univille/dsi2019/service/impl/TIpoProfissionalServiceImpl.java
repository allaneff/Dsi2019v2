package br.univille.dsi2019.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.dsi2019.model.TipoProfissional;
import br.univille.dsi2019.repository.TipoProfissionalRepository;
import br.univille.dsi2019.service.TipoProfissionalService;

@Service
public class TIpoProfissionalServiceImpl implements TipoProfissionalService{

	@Autowired
	private TipoProfissionalRepository repository;
	
	@Override
	public List<TipoProfissional> getAll() {
		return repository.findAll();
	}

	@Override
	public void save(TipoProfissional tipoProfissional) {
		repository.save(tipoProfissional);
		
	}

	@Override
	public void delete(TipoProfissional tipoProfissional) {
		repository.delete(tipoProfissional);
	}

}
