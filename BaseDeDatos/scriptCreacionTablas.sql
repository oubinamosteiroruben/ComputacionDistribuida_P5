create table usuario
(
    id varchar(20) not null primary key,
    -- se almacena la contraseña hasheada
    contrasenha text not null,
    -- se almacena la semilla para poder recuperarla más adelante
    salt text not null
);

create table amistad
(
    amigo1 varchar(20) not null,
    amigo2 varchar(20) not null,
    primary key (amigo1, amigo2)
);

create table solicitudAmistad
(
    -- el id se autoincrementa
    id serial primary key,
    amigoEmisor varchar(20) not null,
    amigoReceptor varchar(20) not null,
    estado char(1) not null,
    -- los estados solo pueden ser: a (aceptada), r (rechazada) o p (pendiente)
    check (estado='a' or estado='r' or estado='p')
);
