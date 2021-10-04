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