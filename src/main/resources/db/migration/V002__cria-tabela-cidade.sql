CREATE TABLE cidade (
	id bigint not null auto_increment,
	nome_cidade varchar(80) not null,
	nome_estado varchar(80) not null,

	primary key (id)
) ENGINE=InnoDB default CHARSET=utf8mb4;