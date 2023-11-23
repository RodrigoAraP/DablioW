package br.com.DablioW.projeto.repository;

import br.com.DablioW.projeto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByNomeAndSenha(String nome, String senha);
}