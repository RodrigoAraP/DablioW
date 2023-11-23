package br.com.DablioW.projeto.DAO;

import br.com.DablioW.projeto.model.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IMensagem extends JpaRepository<Mensagem, Integer> {

    Optional<Mensagem> findById(Integer id_msg);
}
