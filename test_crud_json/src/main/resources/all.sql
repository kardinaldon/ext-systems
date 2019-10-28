DROP TABLE IF EXISTS test_crud_json.main_data;
DROP TABLE IF EXISTS test_crud_json.currency_data;

create table test_crud_json.main_data (
    id integer not null unique,
    data varchar(300),
    previousDate varchar(300),
    previousURL varchar(300),
    timestamp varchar(300),
    currency_name varchar(300) unique ,
    PRIMARY KEY (id)
);

create table test_crud_json.currency_data (
    name_of_currency varchar(300) unique ,
    id varchar(300),
    numCode varchar(300),
    charCode varchar(300),
    nominal varchar(300),
    shortName varchar(300),
    value varchar(300),
    previousValue varchar(300),
    FOREIGN KEY (name_of_currency)  REFERENCES test_crud_json.main_data (currency_name),
    PRIMARY KEY (name_of_currency)
);