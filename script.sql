-- CLIENTES definition

CREATE TABLE CLIENTES (
    id_cliente INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    sobrenome TEXT NOT NULL,
    cpf TEXT NOT NULL UNIQUE,
    email TEXT NOT NULL UNIQUE,
    ddd TEXT NOT NULL,
    numero_celular TEXT NOT NULL,
    id_ordem INTEGER
);


-- ESTOQUE definition

CREATE TABLE ESTOQUE (
    id_peca INTEGER PRIMARY KEY AUTOINCREMENT,
    nome_peca TEXT NOT NULL,
    quantidade INTEGER NOT NULL,
    valor REAL NOT NULL
, modelo TEXT);


-- ordem_servico definition

CREATE TABLE ordem_servico (
    id_ordem INTEGER PRIMARY KEY AUTOINCREMENT,
    id_cliente INTEGER,
    titulo_pedido TEXT,
    preco REAL,
    data_entrada TEXT,
    data_saida TEXT,
    modelo TEXT,
    ano INTEGER,
    descricao_problema TEXT,
    estado_aparelho TEXT,
    imei TEXT,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);

-- Inserting data into ESTOQUE
INSERT INTO ESTOQUE (nome_peca,quantidade,valor,modelo) VALUES
	 ('Bateria iPhone',10,450.0,NULL),
	 ('Tela S21',20,130.5,NULL),
	 ('Camera Xiaomi',15,320.75,NULL),
	 ('Placa Motorola',5,980.0,NULL),
	 ('Carregador USB-C',30,45.9,NULL),
	 ('Tela Samsung',8,550.0,NULL),
	 ('Bateria LG',12,150.0,NULL);
