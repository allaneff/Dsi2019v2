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

import br.univille.dsi2019.model.TipoPagamento;
import br.univille.dsi2019.service.TipoPagamentoService;

@Controller
@RequestMapping("/tipoPagamento")
public class TipoPagamentoController {

	
	@Autowired
	private TipoPagamentoService tipoPagamentoService;
	
	@GetMapping()
	public ModelAndView index() {
		List<TipoPagamento> lista = tipoPagamentoService.getAll();
		return new ModelAndView("tipoPagamento/index", "tipoPagamentos", lista);
	}
	
	@GetMapping("/novo")
	public ModelAndView createFrom(@ModelAttribute TipoPagamento tipoPagamento) {
		return new ModelAndView("tipoPagamento/form");
	}
	
	@PostMapping(params="form")
	public ModelAndView save(@Valid TipoPagamento tipoPagamento) {
		
		tipoPagamentoService.save(tipoPagamento);
		return new ModelAndView("redirect:/tipoPagamento");
	}
	
	@GetMapping(value="/edit/{id}")
	public ModelAndView edit(@PathVariable("id") TipoPagamento tipoPagamento) {
		return new ModelAndView("tipoPagamento/form", "tipoPagamento", tipoPagamento);
	}
	
	@GetMapping(value="/delete/{id}")
	public ModelAndView delete(@PathVariable("id") TipoPagamento tipoPagamento) {
		tipoPagamentoService.delete(tipoPagamento);
		return new ModelAndView("redirect:/tipoPagamento");
	}
}
