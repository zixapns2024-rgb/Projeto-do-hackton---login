package br.com.equipe3.sistemaacademico.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.equipe3.sistemaacademico.DAO.IUsuario;
import br.com.equipe3.sistemaacademico.model.Usuario;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private IUsuario dao;
	
	@GetMapping
	public List<Usuario> listaUsuarios() {
		return (List<Usuario>) dao.findAll();
	}
	
	@PostMapping
	public Usuario criarUsuario(@RequestBody Usuario usuario) {
		Usuario novoUsuario = dao.save(usuario);
		return novoUsuario;
	}
	
	@PutMapping
	public Usuario editarUsuario(@RequestBody Usuario usuario) {
		Usuario novoUsuario = dao.save(usuario);
		return novoUsuario;
	}
	
	@DeleteMapping("/{id}")
	public Optional<Usuario> deletarUsuario(@PathVariable Integer id) {
		Optional<Usuario> usuario = dao.findById(id);
		dao.deleteById(id);
		return usuario;
	}
	
	@PostMapping("/login")
	public boolean login(@RequestBody Usuario usuario) {

	    Optional<Usuario> usuarioEncontrado =
	        dao.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());

	    return usuarioEncontrado.isPresent();
	}
	
}
