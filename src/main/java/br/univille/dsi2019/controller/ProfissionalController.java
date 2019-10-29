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

import br.univille.dsi2019.model.Profissional;
import br.univille.dsi2019.service.ProfissionalService;

@Controller
@RequestMapping("/Profissional")
public class ProfissionalController {
	@Autowired
	private ProfissionalService profissionalService;
	
	@GetMapping()
	public ModelAndView index() {
		List<Profissional> lista = profissionalService.getAll();
		return new ModelAndView("profissional/index", "profissionais", lista);
	}
	
	@GetMapping("/novo")
	public ModelAndView createFrom(@ModelAttribute Profissional profissional) {
		return new ModelAndView("profissional/form");
	}
	
	@PostMapping(params="form")
	public ModelAndView save(@Valid Profissional profissional) {
		
		profissionalService.save(profissional);
		return new ModelAndView("redirect:/profissional");
	}
	
	@GetMapping(value="/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Profissional profissional) {
		return new ModelAndView("profissional/form", "profissional", profissional);
	}
	
	@GetMapping(value="/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Profissional profissional) {
		profissionalService.delete(profissional);
		return new ModelAndView("redirect:/cliente");
	}
}
