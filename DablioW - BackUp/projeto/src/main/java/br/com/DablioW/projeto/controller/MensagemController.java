package br.com.DablioW.projeto.controller;

import br.com.DablioW.projeto.DAO.IUsuario;
import br.com.DablioW.projeto.DAO.IMensagem;
import br.com.DablioW.projeto.model.Mensagem;
import br.com.DablioW.projeto.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*") // Substitua pelo front-end URL apropriado
@RequestMapping("/mensagens")
public class MensagemController {

    private final IMensagem mensagemDAO;
    private final IUsuario usuarioDAO;

    @Autowired
    public MensagemController(IMensagem mensagemDAO, IUsuario usuarioDAO) {
        this.mensagemDAO = mensagemDAO;
        this.usuarioDAO = usuarioDAO;
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<List<Mensagem>> listarMensagensPorUsuario(@PathVariable Integer idUsuario) {
        Optional<Usuario> usuarioOptional = usuarioDAO.findById(idUsuario);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            List<Mensagem> lista = mensagemDAO.findByUsuario(usuario);
            return ResponseEntity.status(HttpStatus.OK).body(lista);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Mensagem> salvarMensagem(@RequestBody Mensagem mensagem) {
        Mensagem mensagemNova = mensagemDAO.save(mensagem);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagemNova);
    }
}
