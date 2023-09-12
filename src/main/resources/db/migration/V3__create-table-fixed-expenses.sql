create table public.fixed_expenses(
    id SERIAL primary key unique not null,
    house_or_apartment varchar(255),
    condominium_fee varchar(100),
    iptu varchar(100),
    water_bill varchar(100),
    electricity_bill varchar(100),
    user_id int,
    foreign key(user_id) references public.user(id)
);