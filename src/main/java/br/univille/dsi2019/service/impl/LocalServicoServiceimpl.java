package br.univille.dsi2019.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.dsi2019.model.LocalServico;
import br.univille.dsi2019.repository.LocalServicoRepository;
import br.univille.dsi2019.service.LocalServicoService;

@Service
public class LocalServicoServiceimpl implements LocalServicoService {

	@Autowired
	private LocalServicoRepository repository;
	
	@Override
	public List<LocalServico> getAll() {
		return repository.findAll();
	}

	@Override
	public void save(LocalServico localServico) {
		repository.save(localServico);
		
	}

	@Override
	public void delete(LocalServico localServico) {
		repository.delete(localServico);
		
	}
	
	

}
