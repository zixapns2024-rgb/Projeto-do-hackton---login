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

import br.com.equipe3.sistemaacademico.model.Aluno;
import br.com.equipe3.sistemaacademico.service.AlunoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/alunos")
public class AlunoController {

	private AlunoService alunoService;

	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	@GetMapping
	public ResponseEntity<List<Aluno>> listaAluno() {
		return ResponseEntity.status(200).body(alunoService.listarAluno());
	}

	@PostMapping
	public ResponseEntity<Aluno> criarAluno(@RequestBody Aluno aluno) {
		return ResponseEntity.status(201).body(alunoService.criarAluno(aluno));
	}

	@PutMapping
	public ResponseEntity<Aluno> editarAluno(@RequestBody Aluno aluno) {
		return ResponseEntity.status(201).body(alunoService.editarAluno(aluno));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarAluno(@PathVariable Integer id) {
		alunoService.deletarAluno(id);
		return ResponseEntity.status(204).build();
	}

}
