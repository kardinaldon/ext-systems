DROP TABLE IF EXISTS cr_address_person;
DROP TABLE IF EXISTS cr_person;
DROP TABLE IF EXISTS cr_address;
DROP TABLE IF EXISTS cr_street;
DROP TABLE IF EXISTS cr_district;

create table cr_district (
    district_code integer not null,
    district_name varchar(300),
    PRIMARY KEY (district_code)
);

insert into cr_district (district_code,district_name) values (1,'Выборгский');

CREATE TABLE cr_street
(
    street_code integer not null,
    street_name varchar(300),
    PRIMARY KEY (street_code)
);

insert into cr_street ( street_code,street_name) values (1,'Cампсониевский проспект');

CREATE TABLE cr_address
(
    address_id serial,
    district_code integer not null,
    street_code integer not null,
    building varchar(10) not null,
    extension varchar(10),
    apartment varchar(10),
    PRIMARY KEY (address_id),
    FOREIGN KEY (street_code) REFERENCES cr_street(street_code) ON DELETE RESTRICT,
    FOREIGN KEY (district_code) REFERENCES cr_district(district_code) ON DELETE RESTRICT
);

insert into cr_address ( district_code,street_code,building,extension,apartment) values (1,1,'10','2','121');

create table cr_person (
    person_id SERIAL,
    sur_name varchar(100) not null,
    given_name varchar(100) not null,
    patronymic varchar(100) not null,
    date_of_birth date not null,
    passport_seria varchar(10),
    passport_number varchar(10),
    passport_date date,
    certificate_number varchar(10),
    certificate_date date,
    PRIMARY KEY (person_id)
);

insert into cr_person ( sur_name,given_name,patronymic,date_of_birth,passport_seria,passport_number,passport_date,certificate_number,certificate_date)
values ('Васильев','Павел','Николаевич','1995-03-18','1234', '123456','2015-04-11',null ,null );

insert into cr_person ( sur_name,given_name,patronymic,date_of_birth,passport_seria,passport_number,passport_date,certificate_number,certificate_date)
values ('Васильева','Ирина','Петровна','1997-08-21','4321', '654321','2017-09-19',null ,null);

insert into cr_person ( sur_name,given_name,patronymic,date_of_birth,passport_seria,passport_number,passport_date,certificate_number,certificate_date)
values ('Васильева','Евгения','Павловна','2016-01-11',null ,null,null,'456123','2016-01-21');

insert into cr_person ( sur_name,given_name,patronymic,date_of_birth,passport_seria,passport_number,passport_date,certificate_number,certificate_date)
values ('Васильева','Александр','Павлович','2018-10-24',null ,null,null,'321654','2018-11-09');

create table cr_address_person (
    person_address_id serial,
    address_id integer not null,
    personId integer not null,
    start_date date not null,
    end_date integer,
    temporal boolean default false,
    PRIMARY KEY (person_address_id),
    FOREIGN KEY (address_id) REFERENCES cr_address(address_id) ON DELETE RESTRICT,
    FOREIGN KEY (personId) REFERENCES cr_person(person_id) ON DELETE RESTRICT
);

insert into cr_address_person (address_id,personId,start_date,end_date) values (1,1,'2014-10-12',null,false);
insert into cr_address_person (address_id,personId,start_date,end_date) values (1,1,'2014-10-12',null);
insert into cr_address_person (address_id,personId,start_date,end_date) values (1,1,'2016-02-05',null);
insert into cr_address_person (address_id,personId,start_date,end_date) values (1,1,'2018-12-11',null);