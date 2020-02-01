create table clientes
(
    id       int auto_increment  primary key,
    nome     varchar(200) not null,
    cpf      varchar(12)  not null,
    telefone varchar(11)  null,
    endereco varchar(200) null
);


