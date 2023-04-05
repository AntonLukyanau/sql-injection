create table if not exists person (
                                      id bigserial primary key,
                                      person_name varchar(255)
);

create table if not exists address (
                                       id bigserial primary key,
                                       address_value varchar(255)
);

insert into person (person_name)
values ('Kostia'),
       ('Ksenia'),
       ('Kostia');

insert into address (address_value)
values ('sensitive data1'),
       ('sensitive data2');