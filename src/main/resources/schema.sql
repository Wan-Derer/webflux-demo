create table app_user
(
    usr_id        integer auto_increment not null
        primary key,
    usr_name      varchar(32)            not null,
    usr_password  varchar(255),
    usr_authority varchar(255)
);
