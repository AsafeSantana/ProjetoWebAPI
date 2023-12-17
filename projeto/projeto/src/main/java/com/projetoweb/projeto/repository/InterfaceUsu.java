package com.projetoweb.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.projetoweb.projeto.model.Usuario;

public interface InterfaceUsu extends JpaRepository <Usuario, Integer>{
    
}
