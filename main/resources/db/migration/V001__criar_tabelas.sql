create table tb_filme (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100) not null,
genero VARCHAR(100) not null, 
classificacao BIGINT not null,
data VARCHAR(100) not null,
horarioinicio VARCHAR(100) not null,
horariofim VARCHAR(100) not null,
sala_id BIGINT
);

create table tb_sala (
id BIGINT AUTO_INCREMENT PRIMARY KEY, 
numerosala INT not null,
assentos INT not null);


Alter table tb_filme add foreign key(sala_id) references tb_sala(id);


Create table tb_compra(
id BIGINT AUTO_INCREMENT PRIMARY KEY, 
filme_id BIGINT NOT NULL,
quantidade INT NOT NULL);

Alter table tb_compra add foreign key(filme_id) references tb_filme(id);



Insert into tb_sala(id, numerosala, assentos) values (1 , 1 , 100);
Insert into tb_sala(id, numerosala, assentos) values (2 , 2 , 100);
Insert into tb_sala(id, numerosala, assentos) values (3 , 3 , 100);




Insert into tb_filme(id , nome , genero , classificacao, data ,horarioinicio, horariofim, sala_id) values (1, 'Spider Man No Way Home', 'Ação', 14 , '21/12/2021','14:00', '15:30',1);

Insert into tb_filme( id , nome , genero , classificacao, data ,horarioinicio, horariofim, sala_id) values (2, 'John Wick 3', 'Ação' , 16 , '21/12/2021','16:00', '17:30',1);

Insert into tb_filme( id , nome , genero , classificacao, data ,horarioinicio, horariofim, sala_id) values (3, 'Ron Bugado', 'Infantil' , 5 , '22/12/2021','16:00', '17:30',2);

Insert into tb_filme ( id , nome , genero , classificacao, data ,horarioinicio, horariofim, sala_id) values (4, 'Minha Mãe é uma Peça 2', 'Comédia' , 12 , '22/12/2021','18:00', '19:30',2);


                       
                       
Insert into tb_compra(id, filme_id, quantidade) values (1 , 1 , 4);

