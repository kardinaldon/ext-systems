DROP TABLE IF EXISTS order_item;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS producer;
DROP TABLE IF EXISTS category;




create table category (
    id integer not null unique,
    name varchar(60),
    url varchar(60) unique,
    product_count integer,
    PRIMARY KEY (id)
);

create table producer (
    id integer not null unique,
    name varchar(60),
    product_count integer,
    PRIMARY KEY (id)
);

create table product (
    id integer not null unique,
    name varchar(255),
    description text,
    image_link varchar(255),
    price numeric (8,2),
    id_category integer not null,
    id_producer integer not null,
    PRIMARY KEY (id),
    FOREIGN KEY (id_category) REFERENCES category(id) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (id_producer) REFERENCES producer(id) ON DELETE RESTRICT ON UPDATE CASCADE
);

create table account (
    id integer not null unique,
    name varchar(60),
    email varchar(100) unique,
    PRIMARY KEY (id)
);

create table orders (
    id bigint not null unique,
    id_account integer not null,
    created timestamp default now(),
    PRIMARY KEY (id),
    FOREIGN KEY (id_account) REFERENCES account(id) ON DELETE RESTRICT ON UPDATE CASCADE
);

create table order_item (
    id bigint not null unique,
    id_order bigint not null,
    id_product integer not null,
    count integer not null,
    PRIMARY KEY (id),
    FOREIGN KEY (id_order) REFERENCES orders(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id_product) REFERENCES product(id) ON DELETE RESTRICT ON UPDATE CASCADE
);

create sequence if not exists account_seq minvalue 1 maxvalue 999999999;
create sequence if not exists orders_seq minvalue 1 maxvalue 999999999;
create sequence if not exists order_item_seq minvalue 1 maxvalue 999999999;
