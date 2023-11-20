-- Insere cidades na tabela "cidades"
--preciso criar a tabela cidade quando estou usando o JPA?
INSERT INTO CIDADES (id,nome, custo_basico_para_sao_paulo) VALUES
  (1,'São Paulo', 10.0),
  (2,'Porto Alegre', 25.0),
  (3,'Curitiba', 15.0),
  (4,'Florianópolis', 20.0);

INSERT INTO orcamentos (id,cidade_origem, cidade_destino, peso, custo_total, custo_impostos, desconto, data_orcamento)
VALUES (1,'05014-901', '90619-900', 100, 500.0, 50.0, 10.0, '2023-9-11');

INSERT INTO orcamentos (id,cidade_origem, cidade_destino, peso, custo_total, custo_impostos, desconto, data_orcamento)
VALUES (2,'90619-900', '80215-901', 150, 750.0, 75.0, 15.0, '2023-10-11');



