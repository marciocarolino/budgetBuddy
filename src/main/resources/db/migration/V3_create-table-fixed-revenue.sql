CREATE TABLE public.fixed_revenue(
  id SERIAL PRIMARY KEY,
  name_revenue varchar(100),
  description_revenue varchar(255),
  value varchar(50),
  user_id int,
  foreign key(user_id) references public.user(id)
);