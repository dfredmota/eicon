----------------- CLIENTES ----------------------------------

insert into clientes(nome,cpf,telefone,endereco)
value ('Fred Mota','01282929380','982177538','Rua Sousa Mota Nº 110');

insert into clientes(nome,cpf,telefone,endereco)
value ('Eicon','000000000','99856369','Sao Paulo - SP');

----------------- PEDIDOS ----------------------------------

-- PEDIDO 1 - Cliente 1
insert into pedidos(created_at, cliente_id, observacoes, valor_total) values
(NOW(),1,'Entregar na portaria',450.0);

insert into item_pedido(descricao, valor, pedido_id, quantidade) values
('Drone',200.00,1,1);

insert into item_pedido(descricao, valor, pedido_id, quantidade) values
('Iphone X',200.00,1,2);

-- PEDIDO 2 - Cliente 1

insert into pedidos(created_at, cliente_id, observacoes, valor_total) values
(NOW(),1,'cuidado frágil',900.0);

insert into item_pedido(descricao, valor, pedido_id, quantidade) values
('Celular A80',450.00,2,1);

insert into item_pedido(descricao, valor, pedido_id, quantidade) values
('Carregador',150.00,2,3);

-- PEDIDO 3 - Cliente 1

insert into pedidos(created_at, cliente_id, observacoes, valor_total) values
(NOW(),1,'Inflamavel',50.0);

insert into item_pedido(descricao, valor, pedido_id, quantidade) values
('Querosene 500ml',25.00,3,1);

insert into item_pedido(descricao, valor, pedido_id, quantidade) values
('Oleo Diesel 1LT',25.00,3,1);

-- PEDIDO 4 - Cliente 1

insert into pedidos(created_at, cliente_id, observacoes, valor_total) values
(NOW(),1,'Entregar somente com assinatura',5000.00);

insert into item_pedido(descricao, valor, pedido_id, quantidade) values
('Notbook Lenovo',2500.00,4,1);

insert into item_pedido(descricao, valor, pedido_id, quantidade) values
('Tv OLED 55',2500.00,4,1);

-- PEDIDO 5 - Cliente 1

insert into pedidos(created_at, cliente_id, observacoes, valor_total) values
(NOW(),1,'Entregar somente com assinatura',2000.00);

insert into item_pedido(descricao, valor, pedido_id, quantidade) values
('Notbook DELL',2000.00,5,1);

-- PEDIDO 6 - Cliente 2

insert into pedidos(created_at, cliente_id, observacoes, valor_total) values
(NOW(),2,'Sem Cebola',45.00);

insert into item_pedido(descricao, valor, pedido_id, quantidade) values
('Pizza Calabresa',45.00,6,1);

-- PEDIDO 7 - Cliente 2

insert into pedidos(created_at, cliente_id, observacoes, valor_total) values
(NOW(),2,'Acrescentar granola',15.00);

insert into item_pedido(descricao, valor, pedido_id, quantidade) values
('Açai 1Lt',15.00,7,1);

-- PEDIDO 8 - Cliente 2

insert into pedidos(created_at, cliente_id, observacoes, valor_total) values
(NOW(),2,'Frágil',150.00);

insert into item_pedido(descricao, valor, pedido_id, quantidade) values
('Ventilador Turbo',75.00,8,1);

insert into item_pedido(descricao, valor, pedido_id, quantidade) values
('Aquecedor',75.00,8,1);

-- PEDIDO 9 - Cliente 2

insert into pedidos(created_at, cliente_id, observacoes, valor_total) values
(NOW(),2,'Sem Obervações',350.00);

insert into item_pedido(descricao, valor, pedido_id, quantidade) values
('Memoria 1GB HIPER',350.00,9,1);

-- PEDIDO 10 - Cliente 2

insert into pedidos(created_at, cliente_id, observacoes, valor_total) values
(NOW(),2,'Entregar ao Professo Joao',150.00);

insert into item_pedido(descricao, valor, pedido_id, quantidade) values
('Java Como Programar 9º Edição',150.00,10,1);
