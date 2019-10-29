package br.univille.dsi2019.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.dsi2019.model.LocalServico;

@Service
public interface LocalServicoService {
	
	List<LocalServico> getAll();
	void save(LocalServico localServico);
	void delete(LocalServico localServico);

}
