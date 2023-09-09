create table public.user(
    id SERIAL primary key unique not null,
    name varchar(255),
    email varchar(255),
    password varchar(255)
);