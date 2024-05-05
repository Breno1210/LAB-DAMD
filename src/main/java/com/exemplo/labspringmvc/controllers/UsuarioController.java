package com.exemplo.labspringmvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.labspringmvc.models.Usuario;
import com.exemplo.labspringmvc.repository.UsuarioRespository;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRespository usuarioRepository;

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable Long id) {
        return usuarioRepository.findById(id).get();
    }

    @PostMapping
    public Usuario adicionarUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizaUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario existingUser = usuarioRepository.findById(id).get();
        existingUser.setNome(usuario.getNome());
        existingUser.setSenha(usuario.getSenha());
        return usuarioRepository.save(existingUser);
    }

    @DeleteMapping("/{id}")
    public String deletaUsuario(@PathVariable Long id) {
        try {
            usuarioRepository.findById(id).get();
            usuarioRepository.deleteById(id);
            return "Usuario deletado com sucesso";
        } catch (Exception e) {
            return "Usuario nao encontrado";
        }
    }
}
