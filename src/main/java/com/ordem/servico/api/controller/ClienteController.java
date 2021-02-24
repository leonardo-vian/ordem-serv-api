package com.ordem.servico.api.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.ordem.servico.domain.model.Cliente;
import com.ordem.servico.domain.repository.ClienteRepository;
import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/clientes")	
	public List<Cliente> listar()
	{
		return clienteRepository.findAll();
	}
	
	@GetMapping("/clientes/{clienteId}")	
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId)
	{
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		
		if (cliente.isPresent()){
			return ResponseEntity.ok(cliente.get());
		}
		
		return ResponseEntity.notFound().build();				
	}
	
	@PostMapping
	public Cliente adicionar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
		
	}
}
