package br.univille.dsi2019.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.dsi2019.model.Profissional;
import br.univille.dsi2019.repository.ProfissionalRepository;
import br.univille.dsi2019.service.ProfissionalService;

@Service
public class ProfissionalServiceImpl implements ProfissionalService {

	@Autowired
	private ProfissionalRepository repository;
	
	@Override
	public List<Profissional> getAll() {
		
		return repository.findAll();
	}

	@Override
	public void save(Profissional profissional) {
		repository.save(profissional);
		
	}

	@Override
	public void delete(Profissional profissional) {
		repository.delete(profissional);
		
	}
	
	
}
