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

import br.univille.dsi2019.model.LocalServico;
import br.univille.dsi2019.service.LocalServicoService;

@Controller
@RequestMapping("/localServico")
public class LocalServicoController {
	
	@Autowired
	private LocalServicoService localServicoService;
	
	@GetMapping()
	public ModelAndView index() {
		List<LocalServico> lista = localServicoService.getAll();
		return new ModelAndView("localServico/index", "localServicos", lista);
	}
	
	@GetMapping("/novo")
	public ModelAndView createFrom(@ModelAttribute LocalServico localServico) {
		return new ModelAndView("localServico/form");
	}
	
	@PostMapping(params="form")
	public ModelAndView save(@Valid LocalServico localServico) {
		
		localServicoService.save(localServico);
		return new ModelAndView("redirect:/localServico");
	}
	
	@GetMapping(value="/edit/{id}")
	public ModelAndView edit(@PathVariable("id") LocalServico localServico) {
		return new ModelAndView("localServico/form", "localServico", localServico);
	}
	
	@GetMapping(value="/delete/{id}")
	public ModelAndView delete(@PathVariable("id") LocalServico localServico) {
		localServicoService.delete(localServico);
		return new ModelAndView("redirect:/localServico");
	}
	
}