package br.com.DablioW.projeto.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mensagem")
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_msg")
    private Integer id_msg;

    @Column(name = "txt_msg", columnDefinition = "TEXT", nullable = false)
    private String txt_msg;

    @Column(name = "dt_envio", columnDefinition = "DATETIME")
    private Date dt_envio;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private Usuario usuario;

    public Integer getId_msg() {
        return id_msg;
    }
    public void setId_msg(Integer id_msg) {
        this.id_msg = id_msg;
    }

    public String getTxt_msg() {
        return txt_msg;
    }
    public void setTxt_msg(String txt_msg) {
        this.txt_msg = txt_msg;
    }

    public Date getDt_envio() {
        return dt_envio;
    }
    public void setDt_envio(Date dt_envio) {
        this.dt_envio = dt_envio;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
