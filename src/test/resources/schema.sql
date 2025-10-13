drop table if exists app_user;
create table app_user
(
    usr_id        integer auto_increment not null
        primary key,
    usr_name      varchar(32) not null,
    usr_password  varchar(255),
    usr_authority varchar(255)
);

drop table if exists test_tbl;
create table test_tbl
(
    tst_id   integer auto_increment not null
        primary key,
    tst_desc varchar(255) not null
);


