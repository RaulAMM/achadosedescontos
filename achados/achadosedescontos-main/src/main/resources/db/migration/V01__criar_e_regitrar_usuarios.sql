CREATE TABLE `user` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL,
	`email` varchar(50) NOT NULL,
	`password` varchar(150) NOT NULL,
	`birth_date` date NOT NULL,
    `gender` varchar(30) NOT NULL,
    `active` tinyint(1) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user` (name, email, password, birth_date, gender, active) 
VALUES 
-- Inserindo o usuário Jubscreid.
('Jubscreid', 'jubscreid@yahoo.com', '$2a$10$Ot4XGuyPP7r82nN3WXA0bOL1Qk9gShKDlVuPoyp89HoFnHcwO4Tji', '2000-05-15', 'FEMININO', 1),
-- Inserindo o usuário Rafael.
('Rafael', 'rafael@gmail.com', '$2a$10$Ot4XGuyPP7r82nN3WXA0bOL1Qk9gShKDlVuPoyp89HoFnHcwO4Tji', '1998-09-20', 'MASCULINO', 1),
-- Inserindo o usuário Raul.
('Raul', 'raul@hotmail.com', '$2a$10$Ot4XGuyPP7r82nN3WXA0bOL1Qk9gShKDlVuPoyp89HoFnHcwO4Tji', '1999-07-12', 'MASCULINO', 1),
-- Inserindo o usuário Matheus.
('Matheus', 'matt@bol.com', '$2a$10$Ot4XGuyPP7r82nN3WXA0bOL1Qk9gShKDlVuPoyp89HoFnHcwO4Tji', '2001-03-25', 'MASCULINO', 1),
-- Inserindo o usuário Wivilly.
('Wivilly', 'wivilly@ifsp.edu.com', '$2a$10$Ot4XGuyPP7r82nN3WXA0bOL1Qk9gShKDlVuPoyp89HoFnHcwO4Tji', '2002-11-30', 'MASCULINO', 1);

