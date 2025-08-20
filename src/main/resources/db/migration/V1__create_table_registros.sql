CREATE TABLE registros(

    id bigint not null auto_increment,
    mensagem varchar(100) not null,
    nomeCurso varchar(100) not null,
    titulo varchar(100) not null,

    primary key(id)
);