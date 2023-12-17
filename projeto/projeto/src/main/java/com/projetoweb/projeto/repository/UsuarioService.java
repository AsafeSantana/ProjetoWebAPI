package com.projetoweb.projeto.repository;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.projetoweb.projeto.model.Usuario;

@Service
public class UsuarioService {

    private InterfaceUsu repository;
    private PasswordEncoder passwordEncoder;

    public UsuarioService(InterfaceUsu repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();

    }
    //GET
    public List<Usuario> listarUsuario() {
        List<Usuario> lista = repository.findAll();
        return lista;
    }
    //POST
    public Usuario criarUsuario(Usuario usuario) {
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        Usuario usuarioNovo = repository.save(usuario);
        return usuarioNovo;
    }
    //PUT
    public Usuario editarUsuario(Usuario usuario) {
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        Usuario usuarioNovo = repository.save(usuario);
        return usuarioNovo;
    }   

    //DELETE
    public Boolean deletarUsuario(int id) {
        repository.deleteById(id);
        return true;
    }
	public Boolean validarSenha(Usuario usuario) {
        String senha = repository.getById(usuario.getId()).getSenha();
        Boolean valid =  passwordEncoder.matches(usuario.getSenha(), senha);
		return valid;
	}

}
