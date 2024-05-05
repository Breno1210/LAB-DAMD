package com.exemplo.labspringmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exemplo.labspringmvc.models.Usuario;

@Repository
public interface UsuarioRespository extends JpaRepository<Usuario, Long>{
    
}
