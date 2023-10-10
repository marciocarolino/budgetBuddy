create table public.user(
    id SERIAL primary key,
    name varchar(255),
    email varchar(255),
    password varchar(255),
    actived boolean
);