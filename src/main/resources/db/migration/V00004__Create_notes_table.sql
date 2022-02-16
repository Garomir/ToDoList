create table notes (
    id int not null,
    text varchar(1000) not null,
    done boolean not null,
    user_id int not null,
    primary key(id));