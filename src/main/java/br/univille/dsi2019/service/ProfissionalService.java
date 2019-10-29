package br.univille.dsi2019.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.dsi2019.model.Profissional;

@Service
public interface ProfissionalService {
	List<Profissional> getAll();
	void save(Profissional profissional);
	void delete(Profissional profissional);
}
