package com.projetoweb.projeto.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.projetoweb.projeto.dto.UsuarioDto;
import com.projetoweb.projeto.model.Usuario;
import com.projetoweb.projeto.security.TokenUtil;
import com.projetoweb.projeto.security.Token;


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
    public Token gerarToken(@Valid UsuarioDto usuario) {
        Usuario user = repository.findByNomeOrEmail(usuario.getNome(), usuario.getEmail());
        if(user != null){
            Boolean valid = passwordEncoder.matches(usuario.getSenha(), user.getSenha());
            if(valid) {
                return new Token(TokenUtil.createToken(user));
            }
        }
        return null;
    }

}
