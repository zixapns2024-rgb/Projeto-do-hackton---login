package br.com.equipe3.sistemaacademico.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.equipe3.sistemaacademico.model.Usuario;
import br.com.equipe3.sistemaacademico.repository.IUsuario;

@Service
public class UsuarioService {

	private IUsuario repository;
	private PasswordEncoder passwordEncoder;

	public UsuarioService(IUsuario repository) {
		this.repository = repository;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	public List<Usuario> listarUsuario() {
		List<Usuario> lista = repository.findAll();
		return lista;
	}
	
	public Usuario criarUsuario(Usuario usuario) {
		String encoder = this.passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(encoder);
		Usuario novoUsuario = repository.save(usuario);
		return novoUsuario;
	}
	
	public Usuario editarUsuario(Usuario usuario) {
		String encoder = this.passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(encoder);
		Usuario novoUsuario = repository.save(usuario);
		return novoUsuario;
	}
	
	public Boolean deletarUsuario(Integer id) {
		repository.deleteById(id);
		return true;
	}
	
	public Boolean validarSenha(Usuario usuario) {
	    Usuario usuarioBanco = repository.findByEmail(usuario.getEmail());

	    if (usuarioBanco == null) {
	    	return false;
	    }

	    return passwordEncoder.matches(usuario.getSenha(), usuarioBanco.getSenha());
	}
	
	
	
}
