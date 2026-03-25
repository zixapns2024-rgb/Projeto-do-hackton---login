package br.com.equipe3.sistemaacademico.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.equipe3.sistemaacademico.model.Professor;
import br.com.equipe3.sistemaacademico.repository.IProfessor;

@Service
public class ProfessorService {

	private IProfessor repository;
	private PasswordEncoder passwordEncoder;

	public ProfessorService(IProfessor repository) {
		this.repository = repository;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	public List<Professor> listarProfessor() {
		List<Professor> lista = repository.findAll();
		return lista;
	}
	
	public Professor criarProfessor(Professor professor) {
		String encoder = this.passwordEncoder.encode(professor.getSenha());
		professor.setSenha(encoder);
		Professor novoProfessor = repository.save(professor);
		return novoProfessor;
	}
	
	public Professor editarProfessor(Professor professor) {
		String encoder = this.passwordEncoder.encode(professor.getSenha());
		professor.setSenha(encoder);
		Professor novoProfessor = repository.save(professor);
		return novoProfessor;
	}
	
	public Boolean deletarProfessor(Integer id) {
		repository.deleteById(id);
		return true;
	}
	
	public Boolean validarSenha(Professor professor) {
	    Professor professorBanco = repository.findByEmail(professor.getEmail());

	    if (professorBanco == null) {
	    	return false;
	    }

	    return passwordEncoder.matches(professor.getSenha(), professorBanco.getSenha());
	}
	
	
	
}
