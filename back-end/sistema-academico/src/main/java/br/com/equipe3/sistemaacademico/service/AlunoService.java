package br.com.equipe3.sistemaacademico.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.equipe3.sistemaacademico.model.Aluno;
import br.com.equipe3.sistemaacademico.repository.IAluno;

@Service
public class AlunoService {

	private IAluno repository;

	public AlunoService(IAluno repository) {
		this.repository = repository;
	}
	
	public List<Aluno> listarAluno() {
		List<Aluno> lista = repository.findAll();
		return lista;
	}
	
	public Aluno criarAluno(Aluno Aluno) {
		Aluno novoAluno = repository.save(Aluno);
		return novoAluno;
	}
	
	public Aluno editarAluno(Aluno Aluno) {
		Aluno novoAluno = repository.save(Aluno);
		return novoAluno;
	}
	
	public Boolean deletarAluno(Integer id) {
		repository.deleteById(id);
		return true;
	}
	
}
