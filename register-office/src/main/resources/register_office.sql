drop table if exists ro_marriage_certificate;
drop table if exists ro_birth_certificate;
drop table if exists ro_passport;
drop table if exists ro_person;

create table if not exists ro_person
(
  person_id serial,
  sex smallint not null,
  first_name varchar (100) not null,
  last_name varchar (100) not null,
  patronymic varchar (100),
  date_birth date not null,
  primary key (person_id)
);

create table if not exists ro_passport
(
    passport_id serial,
    person_id integer not null,
    number varchar(100) not null,
    series varchar(100) not null,
    issue_date date not null,
    issue_department varchar(200) not null,
    primary key (passport_id),
    foreign key (person_id) references ro_person(person_id) on delete restrict
);

create table if not exists ro_birth_certificate
(
    birth_certificate_id serial,
    number_certificate varchar(100) not null,
    data_issue date not null,
    person_id integer not null,
    father_id integer,
    mother_id integer,
    primary key (birth_certificate_id),
    foreign key (person_id) references ro_person(person_id) on delete restrict,
    foreign key (father_id) references ro_person(person_id) on delete restrict,
    foreign key (mother_id) references ro_person(person_id) on delete restrict
);

create table if not exists ro_marriage_certificate
(
    marriage_certificate_id serial,
    number_certificate varchar(100) not null,
    date_issue date,
    end_date date,
    active boolean default false,
    husband_id integer not null,
    wife_id integer not null,
    primary key (marriage_certificate_id),
    foreign key (husband_id) references ro_person (person_id) on delete restrict,
    foreign key (wife_id) references ro_person (person_id) on delete restrict
);

insert into ro_person (sex, first_name, last_name, patronymic, date_birth)
values (1, 'Елена', 'Васильева', 'Сергеевна', '1998-03-24'),
       (2, 'Олег', 'Васильев', 'Петрович', '1997-10-16'),
       (2, 'Николай', 'Васильев', 'Олегович', '2018-10-21');

insert into ro_passport (person_id, series, number, issue_date, issue_department)
values (1, '40000', '123456', '2018-04-10', 'Department Passport');

insert into ro_birth_certificate (number_certificate, data_issue, person_id, mother_id, father_id)
values ('123 Birth', '2018-1-01', 3, 1, 2);