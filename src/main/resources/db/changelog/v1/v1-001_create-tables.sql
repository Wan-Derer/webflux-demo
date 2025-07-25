--liquibase formatted sql
--changeset Wanderer:v1-001-01
create table author
(
    id       bigserial
        constraint author_pk
            primary key,
    name     varchar(100) not null
);

create unique index author_id_uindex
    on author (id);


--changeset Wanderer:v1-001-02
create table article
(
    id     bigserial
        constraint article_pk
            primary key,
    title  varchar(200) not null,
    aut_id bigint
        constraint article_author_id_fk
            references author
            on delete set null
);

create unique index article_id_uindex
    on article (id);

