drop database dablioW;

create database dablioW;

use dablioW;

create table usuario(
id integer auto_increment primary key,
nome varchar(200) not null unique,
email varchar(50) not null unique,
senha text not null,
telefone varchar(15) not null
);

create table mensagem (
id_msg integer auto_increment primary key,
txt_msg text not null,
dt_envio datetime,
id_user integer,
foreign key (id_user) references usuario(id)
);

select * from usuario;

