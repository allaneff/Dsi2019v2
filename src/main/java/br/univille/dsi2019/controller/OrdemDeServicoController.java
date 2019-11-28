package br.univille.dsi2019.controller;

import java.util.HashMap;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.univille.dsi2019.model.Cliente;
import br.univille.dsi2019.model.OrdemDeServico;
import br.univille.dsi2019.model.Profissional;
import br.univille.dsi2019.model.TipoPagamento;
import br.univille.dsi2019.model.TipoServico;
import br.univille.dsi2019.repository.ClienteRepository;
import br.univille.dsi2019.repository.OrdemDeServicoRepository;
import br.univille.dsi2019.repository.ProfissionalRepository;
import br.univille.dsi2019.repository.TipoPagamentoRepository;
import br.univille.dsi2019.repository.TipoServicoRepository;

@Controller
@RequestMapping("/ordemDeServico")
public class OrdemDeServicoController {

	@Autowired
	private OrdemDeServicoRepository ordemDeServicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ProfissionalRepository profissionalRepository;
	@Autowired
	private TipoPagamentoRepository tipoPagamentoRepository;
	@Autowired
	private TipoServicoRepository tipoServicoRepository;
	
	@GetMapping()
	public ModelAndView index() {
		List<OrdemDeServico> lista = ordemDeServicoRepository.findAll();
		return new ModelAndView("ordemDeServico/index","listaOrdemDeServico", lista);
	}
	
	@GetMapping("/novo")
	public ModelAndView createFrom(@ModelAttribute OrdemDeServico ordemDeServico) {
		List<Cliente> listaCliente = this.clienteRepository.findAll();
		List<Profissional> listaProfissional = this.profissionalRepository.findAll();
		List<TipoPagamento> listaTipoPagamento = this.tipoPagamentoRepository.findAll();
		List<TipoServico> listaTipoServico = this.tipoServicoRepository.findAll();
		
		HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put("ordemDeServico", ordemDeServico);
		dados.put("listaCLiente", listaCliente);
		dados.put("listaProfissional", listaProfissional);
		dados.put("listaTipoPagamento", listaTipoPagamento);
		dados.put("listaTipoServico", listaTipoServico);
		
		return new ModelAndView("ordemDeServico/form",dados);
	}
	
	@PostMapping(params= {"save"})
	public ModelAndView save(@Valid OrdemDeServico ordemDeServico, BindingResult result, RedirectAttributes redirect) {
		ordemDeServico = this.ordemDeServicoRepository.save(ordemDeServico);
		return new ModelAndView("redirect:/ordemDeServico");
	}
	
	@GetMapping(value="/alterar/{id}")
	public ModelAndView alterarForm(@PathVariable("id") OrdemDeServico ordemDeServico) {
		List<Cliente> listaCliente = this.clienteRepository.findAll();
		List<Profissional> listaProfissional = this.profissionalRepository.findAll();
		List<TipoPagamento> listaTipoPagamento = this.tipoPagamentoRepository.findAll();
		List<TipoServico> listaTipoServico = this.tipoServicoRepository.findAll();
		
		HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put("ordemDeServico", ordemDeServico);
		dados.put("listaCLiente", listaCliente);
		dados.put("listaProfissional", listaProfissional);
		dados.put("listaTipoPagamento", listaTipoPagamento);
		dados.put("listaTipoServico", listaTipoServico);
		
		return new ModelAndView("ordemDeServico/form",dados);
	}
	@GetMapping(value="remover/{id}")
	public ModelAndView remover(@PathVariable ("id") Long id, RedirectAttributes redirect) {
		this.ordemDeServicoRepository.deleteById(id);
		return new ModelAndView("redirect:/ordemDeServico");
	}
}