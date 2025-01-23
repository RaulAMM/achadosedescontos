-- Criação da tabela 'cupom', que armazenará os cupons relacionados aos usuários.
CREATE TABLE `cupom` (
  -- Definição do campo 'id' como BIGINT, não nulo, auto-incrementado, que será a chave primária da tabela.
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  
  -- Definição do campo 'title' para armazenar o título do cupom, com no máximo 100 caracteres.
  `title` VARCHAR(100) NOT NULL,
  
  -- Definição do campo 'expiration_date' para armazenar a data de expiração do cupom.
  `expiration_date` DATE NOT NULL,
  
  -- Definição do campo 'discount_value' para armazenar o valor do desconto, no tipo DOUBLE.
  `discount_value` DOUBLE NOT NULL,
  
  -- Definição do campo 'link' para armazenar o link do cupom, com no máximo 255 caracteres.
  `link` VARCHAR(255) NOT NULL,
  
  -- Definição do campo 'user_id' para armazenar o ID do usuário que criou o cupom. Será uma chave estrangeira.
  `user_id` BIGINT(20) NOT NULL,
  
  -- Definição de 'id' como a chave primária da tabela.
  PRIMARY KEY (`id`),
  
  -- Definição de 'user_id' como chave estrangeira que referencia a tabela 'user' pelo campo 'id'.
  FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `cupom` (title, expiration_date, discount_value, link, user_id) 
VALUES 
-- Cupons de Jubscreid
('Desconto em Eletrônicos', '2025-03-01', 15.00, 'https://example.com/cupom-eletronicos', 1),
('Frete Grátis', '2025-02-28', 0.00, 'https://example.com/frete-gratis', 1),

-- Cupons de Rafael
('10% Off em Livros', '2025-04-15', 10.00, 'https://example.com/cupom-livros', 2),
('20% Off em Roupas', '2025-05-10', 20.00, 'https://example.com/cupom-roupas', 2),

-- Cupons de Raul
('30% Off em Calçados', '2025-06-01', 30.00, 'https://example.com/cupom-calcados', 3),
('Desconto em Games', '2025-04-01', 25.00, 'https://example.com/cupom-games', 3),

-- Cupons de Matheus
('Desconto em Viagens', '2025-08-01', 50.00, 'https://example.com/cupom-viagens', 4),
('Frete Grátis em Eletrônicos', '2025-03-15', 0.00, 'https://example.com/frete-gratis-eletronicos', 4),

-- Cupons de Wivilly
('25% Off em Cosméticos', '2025-07-01', 25.00, 'https://example.com/cupom-cosmeticos', 5),
('Desconto em Produtos de Beleza', '2025-05-20', 20.00, 'https://example.com/cupom-beleza', 5);

