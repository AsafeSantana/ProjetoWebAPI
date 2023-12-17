package com.projetoweb.projeto.repository;

import java.util.List;
import org.springframework.stereotype.Service;
import com.projetoweb.projeto.model.Usuario;

@Service
public class UsuarioService {

    private InterfaceUsu repository;

    public UsuarioService(InterfaceUsu repository) {
        this.repository = repository;

    }
    //GET
    public List<Usuario> listarUsuario() {
        List<Usuario> lista = repository.findAll();
        return lista;
    }
    //POST
    public Usuario criarUsuario(Usuario usuario) {
        Usuario usuarioNovo = repository.save(usuario);
        return usuarioNovo;
    }
    //PUT
    public Usuario editarUsuario(Usuario usuario) {
        Usuario usuarioNovo = repository.save(usuario);
        return usuarioNovo;
    }   

    //DELETE
    public Boolean deletarUsuario(int id) {
        repository.deleteById(id);
        return true;
    }
}
