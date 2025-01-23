CREATE TABLE `user_cupom` (
  `id_user` BIGINT(20) NOT NULL,  
  `id_cupom` BIGINT(20) NOT NULL,
   PRIMARY KEY (`id_user`, `id_cupom`),
   FOREIGN KEY (`id_user`) REFERENCES `user` (`id`),
   FOREIGN KEY (`id_cupom`) REFERENCES `cupom` (`id`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8;

