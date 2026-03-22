package br.com.equipe3.sistemaacademico.DAO;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.equipe3.sistemaacademico.model.Usuario;

public interface IUsuario extends CrudRepository<Usuario, Integer>{
	
	Optional<Usuario> findByEmailAndSenha(String email, String senha);
	
}
