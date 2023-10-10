create table public.fixed_expenses(
  id SERIAL primary key
  name_expenses varchar(100)
  description_expenses varchar(255)
  value varchar(50)
  user_id int,
  foreign key(user_id) references public.user(id)
);