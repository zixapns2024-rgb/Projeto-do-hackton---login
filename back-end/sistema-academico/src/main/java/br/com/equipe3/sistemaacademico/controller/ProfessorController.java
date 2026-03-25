package br.com.equipe3.sistemaacademico.controller;

import java.util.List;

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

import br.com.equipe3.sistemaacademico.model.Professor;
import br.com.equipe3.sistemaacademico.service.ProfessorService;

@RestController
@CrossOrigin("*")
@RequestMapping("/professores")
public class ProfessorController {
	
	private ProfessorService professorService;
	
	public ProfessorController(ProfessorService professorService) {
		this.professorService = professorService;
	}

	@GetMapping
	public ResponseEntity<List<Professor>> listaProfessor() {
		return ResponseEntity.status(200).body(professorService.listarProfessor());
	}
	
	@PostMapping
	public ResponseEntity<Professor> criarProfessor(@RequestBody Professor professor) {
		return ResponseEntity.status(201).body(professorService.criarProfessor(professor));
	}
	
	@PutMapping
	public ResponseEntity<Professor> editarProfessor(@RequestBody Professor professor) {
		return ResponseEntity.status(201).body(professorService.editarProfessor(professor));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarProfessor(@PathVariable Integer id) {
		professorService.deletarProfessor(id);
		return ResponseEntity.status(204).build();
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Professor professor) {
	    boolean valido = professorService.validarSenha(professor);

	    if (valido) {
	        return ResponseEntity.ok().build();
	    } else {
	        return ResponseEntity.status(401).body("Senha inválida");
	    }
	}
}
