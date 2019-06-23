insert into usuario(email, senha) values ('net@email.com', 'pass');
insert into usuario(email, senha) values ('sony@email.com', 'pass');
insert into usuario(email, senha) values ('italo.souza@acordo.com.br', 'pass');

insert into credor(nome, usuario_id ) values ('Net', 1);
insert into credor(nome, usuario_id ) values ('Sony', 2);

insert into devedor(nome, usuario_id ) values ('Italo Souza', 3);

insert into divida(data_criacao, status, titulo, valor,credor_id, devedor_id) values('2019-06-21 14:00:00', 'VENCIDA', 'Internet Fibra 80 mb', 120.00, 1,1);
insert into divida(data_criacao, status, titulo, valor,credor_id, devedor_id) values('2019-06-21 14:01:00', 'VENCIDA', 'Playstation 4', 2500.00, 2,1);
insert into divida(data_criacao, status, titulo, valor,credor_id, devedor_id) values('2019-06-21 14:01:00', 'VENCIDA', 'F1 2019', 183.00, 2,1);