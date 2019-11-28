package br.univille.dsi2019.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.univille.dsi2019.model.OrdemDeServico;

@Service
public interface OrdemDeServicoService {
	List<OrdemDeServico> getAll();
	void save(OrdemDeServico ordemDeServico);
	void delete (OrdemDeServico ordemDeServico);
}
