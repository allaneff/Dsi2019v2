package br.univille.dsi2019.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.dsi2019.model.Cliente;
import br.univille.dsi2019.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteControllerAPI {
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping()
	public ResponseEntity<List<Cliente>> getAll(){
		return new ResponseEntity<List<Cliente>>(clienteService.getAll(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody @Valid Cliente cliente){
		clienteService.save(cliente);
		return ResponseEntity.ok().build();
	}
	
}
