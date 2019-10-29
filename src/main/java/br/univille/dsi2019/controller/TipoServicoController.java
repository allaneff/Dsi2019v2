package br.univille.dsi2019.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.dsi2019.model.TipoServico;
import br.univille.dsi2019.service.TipoServicoService;

@Controller
@RequestMapping("/tipoServico")
public class TipoServicoController {
	
	@Autowired
	private TipoServicoService tipoServicoService;
	
	@GetMapping()
	public ModelAndView index() {
		List<TipoServico> lista = tipoServicoService.getAll();
		return new ModelAndView("tipoServico/index", "tipoServicos", lista);
	}
	
	@GetMapping("/novo")
	public ModelAndView createFrom(@ModelAttribute TipoServico tipoServico) {
		return new ModelAndView("tipoServico/form");
	}
	
	@PostMapping(params="form")
	public ModelAndView save(@Valid TipoServico tipoServico, BindingResult result) {
		
		if(result.hasErrors()) {
			return new ModelAndView("tipoServico/form");
		}
		tipoServicoService.save(tipoServico);
		return new ModelAndView("redirect:/tipoServico");
	}
	
	@GetMapping(value="/edit/{id}")
	public ModelAndView edit(@PathVariable("id") TipoServico tipoServico) {
		return new ModelAndView("tipoServico/form", "tipoServico", tipoServico);
	}
	
	@GetMapping(value="/delete/{id}")
	public ModelAndView delete(@PathVariable("id") TipoServico tipoServico) {
		tipoServicoService.delete(tipoServico);
		return new ModelAndView("redirect:/tipoServico");
	}
}