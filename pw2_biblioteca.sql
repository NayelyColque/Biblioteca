create database pw2_biblioteca;
use pw2_biblioteca;

create table  livro(
	id_livro	bigint	primary key identity,
	titulo		varchar(50)		not null,
	autor		varchar(20)		not null,
	disponivel	varchar(50)		not null);

create table emprestimo(
	id_empr		bigint primary key identity,
	data_empr	date		not null,
	data_dev	date		not null,
	usuario		varchar(20)	not null,
	id_livro	bigint		not null,
	foreign key (id_livro)	references	livro(id_livro));

select * from livro
select * from emprestimo
drop table Livro	
drop table emprestimo

