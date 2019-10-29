package br.univille.dsi2019.controller;

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

import br.univille.dsi2019.model.TipoProfissional;
import br.univille.dsi2019.service.TipoProfissionalService;

@Controller
@RequestMapping("/tipoProfissional")
public class TipoProfissionalController {
	@Autowired
	private TipoProfissionalService tipoProfissionalService;
	
	@GetMapping()
	public ModelAndView index() {
		List<TipoProfissional> lista = tipoProfissionalService.getAll();
		return new ModelAndView("tipoProfissional/index", "tipoProfissionais", lista);
	}
	
	@GetMapping("/novo")
	public ModelAndView createFrom(@ModelAttribute TipoProfissional tipoProfissional) {
		return new ModelAndView("tipoProfissional/form");
	}
	
	@PostMapping(params="form")
	public ModelAndView save(@Valid TipoProfissional tipoProfissional) {
		
		tipoProfissionalService.save(tipoProfissional);
		return new ModelAndView("redirect:/tipoProfissional");
	}
	
	@GetMapping(value="/edit/{id}")
	public ModelAndView edit(@PathVariable("id") TipoProfissional tipoProfissional) {
		return new ModelAndView("tipoProfissional/form", "tipoProfissional", tipoProfissional);
	}
	
	@GetMapping(value="/delete/{id}")
	public ModelAndView delete(@PathVariable("id") TipoProfissional tipoProfissional) {
		tipoProfissionalService.delete(tipoProfissional);;
		return new ModelAndView("redirect:/tipoProfissional");
	}
}
