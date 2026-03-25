package br.com.equipe3.sistemaacademico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.equipe3.sistemaacademico.model.Professor;

public interface IProfessor extends JpaRepository<Professor, Integer>{
	
	Professor findByEmail(String email);
	
}
