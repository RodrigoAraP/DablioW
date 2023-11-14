package br.com.criandoapi.projeto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.beans.XMLEncoder;

@Data

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "O nome é obrigatorio!")
    @Size(min = 3, message = "Nome invalido!")
    @Column(name = "nome", length = 200, nullable = false)
    private String nome;

    @Email(message = "Email invalido!")
    @NotBlank(message = "O email é obrigatorio!")
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @NotBlank(message = "A senha é obrigatorio!")
    @Column(name = "senha", columnDefinition = "TEXT", nullable = false)
    private String senha;

    @NotBlank(message = "O telefone é obrigatorio!")
    @Column(name = "telefone", length = 15, nullable = false)
    private String telefone;

}
