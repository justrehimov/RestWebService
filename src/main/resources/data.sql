create table address(
    id varchar(100) not null,
    address varchar(50),
    zipcode varchar(20),
    primary key (id)
);

create table users(
    id varchar(100) not null,
    name varchar(30),
    surname varchar(30),
    age int,
    address_id varchar(100) not null,
    primary key (id),
    constraint fk_users_address_id_address foreign key (address_id) references address(id)
);