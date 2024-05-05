package com.exemplo.labspringmvc;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.exemplo.labspringmvc.models.Usuario;
import com.exemplo.labspringmvc.repository.UsuarioRespository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UsuarioRepositoryTests {
    @Autowired private UsuarioRespository repo;

    @Test
    public void testSaveUser() {
        // Cria um novo usuário
        Usuario user = new Usuario();
        user.setNome("Breno");
        user.setSenha("1234");

        // Salva o usuário no repositório
        Usuario savedUser = repo.save(user);

        // Verifica se o usuário foi salvo com sucesso
        assertNotNull(savedUser.getId());
        assertEquals("Breno", savedUser.getNome());
        assertEquals("1234", savedUser.getSenha());
    }
}
