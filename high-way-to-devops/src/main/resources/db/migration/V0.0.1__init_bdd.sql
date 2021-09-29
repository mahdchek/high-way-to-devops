create table personne
(
    id   bigint not null
        constraint product_pkey
            primary key,
    first_name varchar(255),
    last_name varchar(255),
    tjm bigint not null,
    login varchar(255),
    password varchar(255)
);

alter table personne
    owner to postgres;
