/*A3 SQL */

create database if not exists medicalSys;

use medicalSys;

create table if not exists usuario(
	user_id int primary key auto_increment,
    nome varchar(150) not null,
    email varchar(150) not null,
    senha varchar(150) not null,
    cpf varchar(50) not null,
    telefone varchar(50) not null
);

create table if not exists medico(
	medico_id int primary key auto_increment,
    especialidade varchar(150) not null
);

create table if not exists paciente(
	paciente_id int primary key auto_increment
);

create table if not exists consulta(
 consulta_id int primary key auto_increment,
 medico_id int,
 paciente_id int,
 data_hora varchar(60) not null, 
 descricao varchar(600) not null
);

alter table consulta add foreign key (medico_id) references medico(medico_id);
alter table consulta add foreign key (paciente_id) references paciente(paciente_id);

