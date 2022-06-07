CREATE TABLE tb_perfil
(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(255) NOT NULL
);


CREATE TABLE tb_usuario
(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
email VARCHAR(255) NOT NULL,
senha VARCHAR(255) NOT NULL,
perfil_id BIGINT,
FOREIGN KEY(perfil_id) REFERENCES tb_perfil(id)
);

Insert into tb_perfil ( id , nome) values (1, 'Admin');
Insert into tb_perfil ( id , nome) values (2, 'User');


Insert into tb_usuario ( email , senha , perfil_id) values ( 'admin@gft.com','$2a$10$Zs5DM2uiD9ePZMrnjp7mSu9e/aQB4azGW7TKnr3bqTMmoDh2.jOlq',1);
Insert into tb_usuario ( email , senha , perfil_id) values ( 'usuario@gft.com','$2a$10$Zs5DM2uiD9ePZMrnjp7mSu9e/aQB4azGW7TKnr3bqTMmoDh2.jOlq',2);
