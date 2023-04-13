create database azienda2
use azienda2;

create table impiegati(
	id bigint auto_increment primary key,
    nome varchar(100) not null,
    cognome varchar(100) not null,
    email varchar(100) not null
);

create table progetti(
	id bigint auto_increment primary key,
    titolo varchar(100) not null,
    descrizione varchar(1000) not null,
    data_inizio char(8),
    impiegato_id bigint references impiegati(id)
);

create table tasks(
	id bigint auto_increment primary key,
    titolo varchar(100) not null,
    descrizione varchar(1000) not null,
    data char(8),
    progetto_id bigint references progetti(id)
);





