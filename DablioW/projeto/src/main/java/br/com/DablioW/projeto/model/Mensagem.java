// package br.com.DablioW.projeto.model;

// import java.sql.Date;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "mensagem")
// public class Mensagem {

// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// @Column(name = "id_msg")
// private Integer id;

// @Column(name = "txt_msg", columnDefinition = "TEXT", nullable = false)
// private String msg;

// @Column(name = "dt_envio", columnDefinition = "DATETIME", nullable = false)
// private Date dt_envio;

// @Column(name = "id_user", columnDefinition = "INTEGER", nullable = false)
// private Integer id_user;

// public Integer getId() {
// return id;
// }

// public void setId(Integer id) {
// this.id = id;
// }

// public String getMsg() {
// return msg;
// }

// public void setMsg(String msg) {
// this.msg = msg;
// }

// public Date getDt_envio() {
// return dt_envio;
// }

// public void setDt_envio(Date dt_envio) {
// this.dt_envio = dt_envio;
// }

// public Integer getId_user() {
// return id_user;
// }

// public void setId_user(Integer id_user) {
// this.id_user = id_user;
// }

// }
