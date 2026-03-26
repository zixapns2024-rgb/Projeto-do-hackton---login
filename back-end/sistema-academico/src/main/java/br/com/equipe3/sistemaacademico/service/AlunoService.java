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
	
	public Aluno buscarPorId(Integer id) {
	    return repository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
	}
	
	public Aluno criarAluno(Aluno aluno) {
		Aluno novoAluno = repository.save(aluno);
		return novoAluno;
	}
	
	public Aluno editarAluno(Aluno aluno) {
		Aluno alunoEditado = repository.save(aluno);
		return alunoEditado;
	}
	
	public Aluno atualizar(Integer id, Aluno alunoAtualizado) {
	    Aluno aluno = repository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

	    aluno.setNome(alunoAtualizado.getNome());
	    aluno.setEmail(alunoAtualizado.getEmail());
	    aluno.setCurso(alunoAtualizado.getCurso());

	    return repository.save(aluno);
	}
	
	public Boolean deletarAluno(Integer id) {
		repository.deleteById(id);
		return true;
	}
	
}
