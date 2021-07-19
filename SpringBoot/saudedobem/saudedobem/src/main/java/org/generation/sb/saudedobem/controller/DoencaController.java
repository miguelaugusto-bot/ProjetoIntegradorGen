package org.generation.sb.saudedobem.controller;

import java.util.List;

import javax.validation.Valid;

import org.generation.sb.saudedobem.model.Doenca;
import org.generation.sb.saudedobem.service.DoencaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doencas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DoencaController {

	@Autowired
	private DoencaService doencaService;
	
	@GetMapping
	public ResponseEntity<List<Doenca>> getAll() {
		return doencaService.findAll();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Doenca> getById(@PathVariable Long id) {
		return doencaService.findById(id);
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<Doenca> getByNome(@PathVariable String nome) {
		return doencaService.findByNome(nome);
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Doenca> postDoenca(@Valid @RequestBody Doenca doenca){
		return doencaService.saveDoenca(doenca);
	}
	
	@PutMapping("/alterar")
	public ResponseEntity<Doenca> putDoenca(@Valid @RequestBody Doenca doenca) {
		return doencaService.updateDoenca(doenca);
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Doenca> deleteDoenca(@Valid @PathVariable Long id){
		return doencaService.deleteDoenca(id);
	}
	
}
