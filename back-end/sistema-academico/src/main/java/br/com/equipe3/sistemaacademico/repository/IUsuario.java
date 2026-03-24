package br.com.equipe3.sistemaacademico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.equipe3.sistemaacademico.model.Usuario;

public interface IUsuario extends JpaRepository<Usuario, Integer>{
	
	Usuario findByEmail(String email);
	
}
