create table usuario
(
    username varchar(20) not null primary key,
    -- se almacena la contraseña hasheada
    password text not null,
    -- se almacena la semilla para poder recuperarla más adelante
    salt text not null
);

create table amistad
(
    amigo1 varchar(20) not null,
    amigo2 varchar(20) not null,
    primary key (amigo1, amigo2),
    foreign key (amigo1)
        references usuario (username)
            on delete cascade
            on update no action,
    foreign key (amigo2)
        references usuario (username)
            on delete cascade
            on update no action
);

create table solicitudAmistad
(
    amigoEmisor varchar(20) not null,
    amigoReceptor varchar(20) not null,
    estado char(1) not null,
    -- los estados solo pueden ser: a (aceptada), r (rechazada) o p (pendiente)
    check (estado='a' or estado='r' or estado='p'),
    primary key (amigoEmisor, amigoReceptor),
    foreign key (amigoEmisor)
        references usuario (username)
            on delete cascade
            on update no action,
    foreign key (amigoReceptor)
        references usuario (username)
            on delete cascade
            on update no action
);
