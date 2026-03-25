package br.com.equipe3.sistemaacademico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.equipe3.sistemaacademico.model.Aluno;

public interface IAluno extends JpaRepository<Aluno, Integer> {

}
