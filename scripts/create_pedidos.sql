create table pedidos
(
    id          int auto_increment   primary key,
    created_at  timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    cliente_id  int                                 not null,
    observacoes varchar(200)                        null,
    valor_total decimal(15, 2)                      null,
    constraint clientes__fk
        foreign key (cliente_id) references clientes (id)
);
