insert into usuario(email, senha) values ('net@email.com', 'pass');
insert into usuario(email, senha) values ('sony@email.com', 'pass');
insert into usuario(email, senha) values ('italo.souza@acordo.com.br', 'pass');
insert into usuario(email, senha) values ('dilson.moura@acordo.com.br', 'pass');

insert into credor(razao_social, usuario_id ) values ('Net', 1);
insert into credor(razao_social, usuario_id ) values ('Sony', 2);

insert into devedor(nome, usuario_id ) values ('Italo Souza', 3);
insert into devedor(nome, usuario_id ) values ('Dilson Moura de Sá', 4);

insert into divida(data_criacao, data_vencimento, status, descricao, valor,credor_id, devedor_id, COBRANCA_JUDICIAL) values('2018-01-02 13:30:00', '2018-04-02 13:30:00', 'VENCIDA', 'Internet Fibra 80 mb', 120.00, 1,1,0);
insert into divida(data_criacao, data_vencimento, status, descricao, valor,credor_id, devedor_id, COBRANCA_JUDICIAL) values('2018-02-14 14:01:00', '2018-07-14 14:01:00', 'VENCIDA', 'Playstation 4', 2500.00, 2,1,0);
insert into divida(data_criacao, data_vencimento, status, descricao, valor,credor_id, devedor_id, COBRANCA_JUDICIAL) values('2018-03-13 15:01:00', '2019-01-13 15:01:00', 'VENCIDA', 'F1 2019', 183.00, 2,2,0);
