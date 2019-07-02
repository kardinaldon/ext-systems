DROP TABLE IF EXISTS person;

create table person (
    person_id integer not null auto_increment,
    person_name varchar(300),
    person_surname varchar(300),
    PRIMARY KEY (person_id)
);

insert into person (person_name, person_surname) values ('Ivan','Petrov');
select * from person;