create table item_pedido
(
    id         int auto_increment primary key,
    descricao  varchar(200)   not null,
    valor      decimal(15, 2) not null,
    pedido_id  int            not null,
    quantidade int            not null,
    constraint pedidos_fk
        foreign key (pedido_id) references pedidos (id)
);


