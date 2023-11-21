drop database banco_de_usuarios;

create database dablioW;

use dablioW;

create table usuario(
id integer auto_increment primary key,
nome varchar(200) not null unique,
email varchar(50) not null unique,
senha text not null,
telefone varchar(15) not null
);

select * from usuario;

