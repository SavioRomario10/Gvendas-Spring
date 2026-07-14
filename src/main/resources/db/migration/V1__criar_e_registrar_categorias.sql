CREATE TABLE categoria (
    codigo BIGSERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

INSERT INTO categoria (nome) VALUES ('Tecnologia');
INSERT INTO categoria (nome) VALUES ('Acessórios para veículos');
INSERT INTO categoria (nome) VALUES ('Esporte e Lazer');
INSERT INTO categoria (nome) VALUES ('Casa e Eletrodomésticos');
INSERT INTO categoria (nome) VALUES ('Joias e Relógios');