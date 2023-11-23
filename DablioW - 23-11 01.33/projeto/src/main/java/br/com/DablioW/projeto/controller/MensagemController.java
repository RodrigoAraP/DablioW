package br.com.DablioW.projeto.controller;

import br.com.DablioW.projeto.DAO.IMensagem;
import br.com.DablioW.projeto.model.Mensagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080") // Substitua pelo front-end URL apropriado
@RequestMapping("/mensagens") // Alterado para '/mensagens'
public class MensagemController {

    private final IMensagem mensagemDAO;

    @Autowired
    public MensagemController(IMensagem mensagemDAO) {
        this.mensagemDAO = mensagemDAO;
    }

    @GetMapping
    public ResponseEntity<List<Mensagem>> listarMensagens() {
        List<Mensagem> lista = mensagemDAO.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @PostMapping
    public ResponseEntity<Mensagem> salvarMensagem(@RequestBody Mensagem mensagem) {
        Mensagem mensagemNova = mensagemDAO.save(mensagem);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagemNova);
    }
}
