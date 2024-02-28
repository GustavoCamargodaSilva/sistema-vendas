INSERT INTO tb_categoria (nome) VALUES ('Camisetas');
INSERT INTO tb_categoria (nome) VALUES ('Tenis');

INSERT INTO tb_produto (nome, preco, descricao, cod_categoria, marca, tamanho) VALUES ('Camiseta', 50.00, 'Camiseta de algodão', 1, 'Nike', 'M');
INSERT INTO tb_produto (nome, preco, descricao, cod_categoria, marca, tamanho) VALUES ('Tenis', 100.00, 'Tenis de corrida', 2, 'Adidas', '42');

INSERT INTO tb_endereco (cep, logradouro, complemento, bairro, localidade, uf, ibge, gia, ddd, siafi) VALUES ('12345678', 'Rua 1', 'Casa 1', 'Bairro 1', 'Cidade 1', 'SP', '1234567', '1234567', '11', '1234567');
INSERT INTO tb_endereco (cep, logradouro, complemento, bairro, localidade, uf, ibge, gia, ddd, siafi) VALUES ('87654321', 'Rua 2', 'Casa 2', 'Bairro 2', 'Cidade 2', 'SP', '8765432', '8765432', '11', '8765432');

INSERT INTO tb_dados_bancarios (agencia, conta, banco, tipo_conta, pix) VALUES ('1234', '123456', 'Bradesco', 'Corrente', '123456789');
INSERT INTO tb_dados_bancarios (agencia, conta, banco, tipo_conta, pix) VALUES ('4321', '654321', 'Itau', 'Poupança', '987654321');

INSERT INTO tb_vendedor (nome, data_nascimento, email, senha, telefone, role, salario_base, dados_bancarios_cod_dados_bancarios, endereco_cod_endereco) VALUES ('Gustavo', '2001-07-25', 'teste@gmail.com', '123456', '11999999999', 1, 1000.00, 1, 1);
INSERT INTO tb_vendedor (nome, data_nascimento, email, senha, telefone, role, salario_base, dados_bancarios_cod_dados_bancarios, endereco_cod_endereco) VALUES ('Augusto', '2001-07-25', 'teste@gmail.com', '1234567', '41997041695', 0, 2000.00, 2, 2);

INSERT INTO tb_cliente (cpf, nome, data_nascimento, email, telefone, status, endereco_cod_endereco) VALUES ('12345678901', 'Gustavo', '2001-07-25', 'gugusilvababolim@gmail.com', '11999999999', 0,1);
INSERT INTO tb_cliente (cpf, nome, data_nascimento, email, telefone, status, endereco_cod_endereco) VALUES ('12345678922', 'Augusto', '2001-07-25', 'teste@gmail.com', '41997041695', 0,2);

INSERT INTO tb_filial(cnpj,nome, fantasia, logradouro, numero, complemento, cep, bairro, municipio, uf, email,telefone) VALUES ('12345678901234', 'Filial 1', 'Filial 1', 'Rua 1', '123', 'Casa 1', '12345678', 'Bairro 1', 'Cidade 1', 'SP', 'teste@gmail.com', '11999999999');

INSERT INTO tb_estoque_filial (quantidade_estoque, cod_produto, cod_filial) VALUES (10, 1, 1);
INSERT INTO tb_estoque_filial (quantidade_estoque, cod_produto, cod_filial) VALUES (10, 2, 1);


