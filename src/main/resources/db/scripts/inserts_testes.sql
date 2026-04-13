-- ==========================================
-- 1. USUÁRIOS, ADMIN E CLIENTES
-- ==========================================
-- Admin Master (ID 1) - tipo_usuario 0 = Admin
INSERT INTO usuario (id, nome, tipo_usuario) VALUES (1, 'Administrador do Sistema', 0);
INSERT INTO administrador (id) VALUES (1);

-- Clientes (IDs 2 a 7) - tipo_usuario 1 = Cliente
INSERT INTO usuario (id, nome, tipo_usuario) VALUES
                                                 (2, 'João Tech', 1),
                                                 (3, 'Maria Bazar', 1),
                                                 (4, 'Eletro Carlos', 1),
                                                 (5, 'Auto Peças Silva', 1),
                                                 (6, 'Papelaria Central', 1),
                                                 (7, 'Mercado Esquina', 1);

-- Vinculando os clientes ao Admin 1
INSERT INTO cliente (id, nome_empresa, id_administrador) VALUES
                                                             (2, 'Tech Solutions Ltda', 1),
                                                             (3, 'Bazar da Maria ME', 1),
                                                             (4, 'Eletro Carlos S.A', 1),
                                                             (5, 'Auto Peças Silva', 1),
                                                             (6, 'Papelaria Central', 1),
                                                             (7, 'Mercado da Esquina', 1);

-- ==========================================
-- 2. CATEGORIAS (3 para cada cliente = 18 categorias)
-- ==========================================
INSERT INTO categoria (id, nome, cliente_id) VALUES
-- Cliente 2 (Tech)
(1, 'Placas Mãe', 2), (2, 'Processadores', 2), (3, 'Memórias RAM', 2),
-- Cliente 3 (Bazar)
(4, 'Cama', 3), (5, 'Mesa', 3), (6, 'Banho', 3),
-- Cliente 4 (Eletro)
(7, 'Geladeiras', 4), (8, 'Fogões', 4), (9, 'Micro-ondas', 4),
-- Cliente 5 (Auto Peças)
(10, 'Óleos', 5), (11, 'Filtros', 5), (12, 'Freios', 5),
-- Cliente 6 (Papelaria)
(13, 'Cadernos', 6), (14, 'Canetas', 6), (15, 'Mochilas', 6),
-- Cliente 7 (Mercado)
(16, 'Bebidas', 7), (17, 'Carnes', 7), (18, 'Limpeza', 7);

-- ==========================================
-- 3. FORNECEDORES (1 para cada cliente)
-- ==========================================
INSERT INTO fornecedor (id, nome, cnpj, cliente_id) VALUES
                                                        (1, 'Intel Distribuidora', '11.111.111/0001-11', 2),
                                                        (2, 'Têxtil Nacional', '22.222.222/0001-22', 3),
                                                        (3, 'Brastemp Atacado', '33.333.333/0001-33', 4),
                                                        (4, 'Lubrax Distribuidora', '44.444.444/0001-44', 5),
                                                        (5, 'Faber-Castell', '55.555.555/0001-55', 6),
                                                        (6, 'Ambev S.A', '66.666.666/0001-66', 7);

-- ==========================================
-- 4. PRODUTOS (5 para cada cliente = 30 produtos)
-- ==========================================
INSERT INTO produto (id, nome, preco, quantidade, estoque_minimo, categoria_id, fornecedor_id, cliente_id) VALUES
-- Cliente 2 (Tech)
(1, 'Placa Mãe B550', 850.00, 15, 5, 1, 1, 2),
(2, 'Processador Core i7', 1500.00, 10, 2, 2, 1, 2),
(3, 'Processador Core i5', 900.00, 20, 5, 2, 1, 2),
(4, 'Memória RAM 16GB', 350.00, 50, 10, 3, 1, 2),
(5, 'Memória RAM 8GB', 180.00, 40, 10, 3, 1, 2),

-- Cliente 3 (Bazar)
(6, 'Jogo de Lençol Casal', 120.00, 30, 5, 4, 2, 3),
(7, 'Edredom Queen', 250.00, 15, 3, 4, 2, 3),
(8, 'Toalha de Mesa', 45.00, 50, 10, 5, 2, 3),
(9, 'Toalha de Banho', 35.00, 100, 20, 6, 2, 3),
(10, 'Toalha de Rosto', 15.00, 120, 20, 6, 2, 3),

-- Cliente 4 (Eletro)
(11, 'Geladeira Frost Free', 3200.00, 5, 2, 7, 3, 4),
(12, 'Geladeira Duplex', 2800.00, 8, 2, 7, 3, 4),
(13, 'Fogão 4 Bocas', 850.00, 12, 3, 8, 3, 4),
(14, 'Fogão 5 Bocas', 1100.00, 6, 2, 8, 3, 4),
(15, 'Micro-ondas 30L', 650.00, 15, 4, 9, 3, 4),

-- Cliente 5 (Auto Peças)
(16, 'Óleo Sintético 5W40', 45.00, 100, 20, 10, 4, 5),
(17, 'Óleo Mineral 20W50', 30.00, 80, 20, 10, 4, 5),
(18, 'Filtro de Ar', 25.00, 50, 10, 11, 4, 5),
(19, 'Filtro de Óleo', 20.00, 60, 15, 11, 4, 5),
(20, 'Pastilha de Freio', 120.00, 30, 8, 12, 4, 5),

-- Cliente 6 (Papelaria)
(21, 'Caderno Universitário', 22.00, 200, 50, 13, 5, 6),
(22, 'Caderno de Desenho', 15.00, 80, 20, 13, 5, 6),
(23, 'Caneta Azul', 2.50, 500, 100, 14, 5, 6),
(24, 'Caneta Vermelha', 2.50, 300, 50, 14, 5, 6),
(25, 'Mochila Escolar', 150.00, 40, 10, 15, 5, 6),

-- Cliente 7 (Mercado)
(26, 'Cerveja Pilsen Lata', 3.50, 600, 100, 16, 6, 7),
(27, 'Refrigerante 2L', 8.00, 300, 50, 16, 6, 7),
(28, 'Picanha Bovina', 85.00, 20, 5, 17, 6, 7),
(29, 'Frango Inteiro', 18.00, 50, 10, 17, 6, 7),
(30, 'Sabão em Pó 1kg', 12.00, 100, 20, 18, 6, 7);

-- ==========================================
-- 5. MOVIMENTAÇÕES DE ESTOQUE (Todos os Clientes)
-- ==========================================

INSERT INTO movimentacao (id, descricao, quantidade, data, produto_id, cliente_id) VALUES
-- ---------------------------------------------------------
-- Cliente 2: Tech Solutions Ltda (Produtos 1 a 5)
-- ---------------------------------------------------------
(1, 'Entrada inicial - Placa Mãe B550', 15, '2026-04-10 09:00:00', 1, 2),
(2, 'Entrada inicial - Core i7', 10, '2026-04-10 09:30:00', 2, 2),
(3, 'Venda Balcão - Montagem PC Gamer', -1, '2026-04-11 14:00:00', 1, 2),
(4, 'Venda Balcão - Montagem PC Gamer', -1, '2026-04-11 14:00:00', 2, 2),

-- ---------------------------------------------------------
-- Cliente 3: Bazar da Maria ME (Produtos 6 a 10)
-- ---------------------------------------------------------
(5, 'Compra de Fornecedor - Lençol', 30, '2026-04-05 10:00:00', 6, 3),
(6, 'Compra de Fornecedor - Toalha de Banho', 100, '2026-04-05 11:00:00', 9, 3),
(7, 'Venda Loja Física', -2, '2026-04-08 15:30:00', 6, 3),
(8, 'Venda Loja Física', -4, '2026-04-08 15:30:00', 9, 3),

-- ---------------------------------------------------------
-- Cliente 4: Eletro Carlos S.A (Produtos 11 a 15)
-- ---------------------------------------------------------
(9, 'Recebimento de Carga - Geladeiras', 5, '2026-04-01 08:00:00', 11, 4),
(10, 'Recebimento de Carga - Fogões', 12, '2026-04-01 09:30:00', 13, 4),
(11, 'Venda Online - Pedido E-commerce #101', -1, '2026-04-04 11:20:00', 11, 4),
(12, 'Venda Loja - Promoção de Dia das Mães', -2, '2026-04-06 16:45:00', 13, 4),

-- ---------------------------------------------------------
-- Cliente 5: Auto Peças Silva (Produtos 16 a 20)
-- ---------------------------------------------------------
(13, 'Estoque Inicial - Óleo 5W40', 100, '2026-04-10 07:30:00', 16, 5),
(14, 'Estoque Inicial - Pastilha de Freio', 30, '2026-04-10 08:15:00', 20, 5),
(15, 'Ordem de Serviço #554 - Revisão Cliente', -4, '2026-04-12 09:00:00', 16, 5),
(16, 'Ordem de Serviço #554 - Revisão Cliente', -1, '2026-04-12 09:00:00', 20, 5),

-- ---------------------------------------------------------
-- Cliente 6: Papelaria Central (Produtos 21 a 25)
-- ---------------------------------------------------------
(17, 'Lote Volta às Aulas - Cadernos', 200, '2026-02-15 10:00:00', 21, 6),
(18, 'Lote Volta às Aulas - Canetas', 500, '2026-02-15 11:30:00', 23, 6),
(19, 'Venda Varejo - Lista de Material Escolar', -5, '2026-02-20 14:10:00', 21, 6),
(20, 'Venda Varejo - Lista de Material Escolar', -15, '2026-02-20 14:10:00', 23, 6),

-- ---------------------------------------------------------
-- Cliente 7: Mercado da Esquina (Produtos 26 a 30)
-- ---------------------------------------------------------
(21, 'Reposição de Câmara Fria - Bebidas', 600, '2026-04-11 06:00:00', 26, 7),
(22, 'Reposição de Açougue - Picanha', 20, '2026-04-11 06:30:00', 28, 7),
(23, 'Movimento de Sábado à noite', -120, '2026-04-11 21:00:00', 26, 7),
(24, 'Movimento de Sábado - Kit Churrasco', -8, '2026-04-11 20:30:00', 28, 7);