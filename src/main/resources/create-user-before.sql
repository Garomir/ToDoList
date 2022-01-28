drop table if exists users_roles;
drop table if exists notes;
drop table if exists users;
drop table if exists roles;

create table users (
    id int primary key auto_increment,
    username varchar(255) not null unique,
    password varchar(255) not null);
create table roles (
    id int primary key auto_increment,
    name varchar(255) not null);
create table users_roles (
    user_id int not null,
    role_id int not null,
    foreign key (user_id) references users(id),
    foreign key (role_id) references roles(id),
    unique(user_id, role_id));
insert into roles values (1, 'ROLE_USER');
insert into roles values (2, 'ROLE_ADMIN');
create table notes (
    id int not null,
    text varchar(1000) not null,
    done boolean not null,
    user_id int not null,
    primary key(id));

insert into users(id, username, password) values (1, 'Ramil', '$2a$10$3Vl28ncAabMw0f95/2d8/eMH.cAjoCNJdY8r7RF2iZIqV6VO2xfxu');
insert into users_roles(user_id, role_id) values (1, 2), (1, 1);