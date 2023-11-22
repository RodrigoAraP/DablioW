package br.com.DablioW.projeto.DAO;

import br.com.DablioW.projeto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsuario extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findAllById(Integer id);
}
