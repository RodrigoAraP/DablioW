package br.com.DablioW.projeto.controller;

import br.com.DablioW.projeto.DAO.IUsuario;
import br.com.DablioW.projeto.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuario dao;

    @GetMapping
    public List<Usuario> listaUsuarios() {
        return (List<Usuario>) dao.findAll();
    }

    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioNovo = dao.save(usuario);
        return usuarioNovo;
    }

    @PutMapping
    public Usuario editarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioNovo = dao.save(usuario);
        return usuarioNovo;
    }

    @DeleteMapping("/{id}")
    public Optional<Usuario> excluirUsuario (@PathVariable Integer id){
        Optional<Usuario> usuario = dao.findAllById(id);
        dao.deleteById(id);
        return usuario;
    }

    



    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        String nome = usuario.getNome();
        String senha = usuario.getSenha();

        // Validar usuário no banco de dados
        if (validarUsuario(nome, senha)) {
            return "Login bem-sucedido!";
        } else {
            return "Nome de usuário ou senha inválidos.";
        }
    }

    private boolean validarUsuario(String nome, String senha) {
        // Substitua as credenciais do banco de dados conforme necessário
        String url = "jdbc:mysql://localhost:3306/dabliow?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "dabliow";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, nome);
                statement.setString(2, senha);
                try (ResultSet resultSet = statement.executeQuery()) {
                    return resultSet.next();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
