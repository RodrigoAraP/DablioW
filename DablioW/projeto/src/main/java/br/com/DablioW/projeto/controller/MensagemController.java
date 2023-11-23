// package br.com.DablioW.projeto.controller;

// import br.com.DablioW.projeto.DAO.IUmensagem;
// import br.com.DablioW.projeto.model.Mensagem;
// import br.com.DablioW.projeto.model.Usuario;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import java.util.Optional;

// @RestController
// @CrossOrigin("*")
// @RequestMapping("/usuarios")
// public class MensagemController {

// @Autowired
// private IUmensagem dao;

// @GetMapping
// public ResponseEntity<List<Mensagem>> listarMensagens() {
// List<Mensagem> lista = (List<Mensagem>) dao.findAll();
// return ResponseEntity.status(200).body(lista);
// }

// @PostMapping
// public ResponseEntity<Mensagem> salvarMensagem(@RequestBody Mensagem
// mensagem) {
// Mensagem mensagemNova = dao.save(mensagem);
// return ResponseEntity.status(201).body(mensagemNova);
// }
// }
