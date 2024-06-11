create database if not exists medicalsys;
use medicalsys;
create table if not exists paciente(
	paciente_id int primary key auto_increment,
    nome varchar(150) not null,
    email varchar(200) not null,
    senha varchar(100) not null,
    cpf varchar(60) not null,
    telefone varchar(60) not null
);
create table if not exists medico(
	medico_id int primary key auto_increment,
	nome varchar(150) not null,
    email varchar(200) not null,
    senha varchar(100) not null,
    cpf varchar(60) not null,
    telefone varchar(60) not null,
    especialidade varchar(150) not null
);
create table if not exists consulta(
	consulta_id int primary key auto_increment,
    data_hora varchar(100) not null,
    motivo_C varchar(6000) not null,
    medico_id int ,
    foreign key (medico_id) references medico(medico_id),
    paciente_id int,
    foreign key (paciente_id) references paciente(paciente_id)
);
create table if not exists prescricao(
	prescricao_id int primary key auto_increment,
    descricao varchar(6000) not null,
    medico_id int,
    foreign key (medico_id) references medico(medico_id),
    paciente_id int,
    foreign key (paciente_id) references paciente(paciente_id),
    consulta_id int,
    foreign key (consulta_id) references consulta(consulta_id)
);