package br.univille.dsi2019.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.dsi2019.model.TipoProfissional;

@Service
public interface TipoProfissionalService {

	List<TipoProfissional> getAll();
	void save(TipoProfissional tipoProfissional);
	void delete(TipoProfissional tipoProfissional);
}
