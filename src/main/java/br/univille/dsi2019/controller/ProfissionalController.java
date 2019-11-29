package br.univille.dsi2019.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.dsi2019.model.Cliente;
import br.univille.dsi2019.model.Profissional;
import br.univille.dsi2019.model.TipoPagamento;
import br.univille.dsi2019.model.TipoProfissional;
import br.univille.dsi2019.repository.ProfissionalRepository;
import br.univille.dsi2019.repository.TipoProfissionalRepository;
import br.univille.dsi2019.repository.TipoServicoRepository;


@Controller
@RequestMapping("/profissional")
public class ProfissionalController {
	@Autowired
	private ProfissionalRepository profissionalRepository;
	@Autowired
	private TipoProfissionalRepository tipoProfissionalRepository;
	
	@GetMapping()
	public ModelAndView index() {
		List<Profissional> lista = profissionalRepository.findAll();
		return new ModelAndView("profissional/index", "profissionais", lista);
	}
	
	@GetMapping("/novo")
	public ModelAndView createFrom(@ModelAttribute Profissional profissional) {
		List<TipoProfissional> listaTipoProfissional = this.tipoProfissionalRepository.findAll();
		
		HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put("profissional", profissional);
		dados.put("listaTipoProfissional", listaTipoProfissional);
		return new ModelAndView("profissional/form", dados);
	}
	
	@PostMapping(params="form")
	public ModelAndView save(@Valid Profissional profissional) {
		
		profissionalRepository.save(profissional);
		return new ModelAndView("redirect:/profissional");
	}
	
	@GetMapping(value="/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Profissional profissional) {
		List<TipoProfissional> listaTipoProfissional = this.tipoProfissionalRepository.findAll();
		
		HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put("profissional", profissional);
		dados.put("listaTipoProfissional", listaTipoProfissional);
		
		return new ModelAndView("profissional/form", "profissional", dados);
	}
	
	@GetMapping(value="/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Profissional profissional) {
		profissionalRepository.delete(profissional);
		return new ModelAndView("redirect:/cliente");
	}
}
