CREATE TABLE student
(
    id              integer     not null,
    first_name      varchar(64) not null,
    last_name       varchar(64) not null,
    passport_series varchar(2)  not null,
    passport_number varchar(6)  not null,
    PRIMARY KEY (id)
);
