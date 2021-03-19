INSERT INTO public.role(name)VALUES ('ROLE_USER');
INSERT INTO public.role(name)VALUES ('ROLE_MODERATOR');
INSERT INTO public.role(name)VALUES ('ROLE_ADMIN');

INSERT INTO public.users(email, full_name, password, phone_number, photo) VALUES ('user@mail.com', 'Simple User', '$2a$10$5kjo5h7CXfub1qYeCTCxye0PsFUk3DxQg006nqjp8IZNS1GOIPYBu', '0932564759', NULL);
INSERT INTO public.users(email, full_name, password, phone_number, photo) VALUES ('moder@mail.com', 'Moder User', '$2a$10$lqNK.aOKeLyZ0p0SuDmJvO3FrH1Y2OkFyLJve4fmkd2St3wookqVC', '0932564760', NULL);
INSERT INTO public.users(email, full_name, password, phone_number, photo) VALUES ('admin@mail.com', 'Admin User', '$2a$10$L2Tg2wXFvRKKGyGNBzwWVeLsG2zNqQGa5mCS7fgLNL1dSgV456i2K', '0932564777', NULL);
INSERT INTO public.user_roles(user_id, role_id)VALUES (1, 1);
INSERT INTO public.user_roles(user_id, role_id)VALUES (2, 2);
INSERT INTO public.user_roles(user_id, role_id)VALUES (3, 3);

INSERT INTO public.handgun(barrel_length, brand, caliber, capacity, color, country, crated_at, description, handgun_type, left_in_stock, model, modified_at, photo, price, total_length, warranty, weight) VALUES (14.8, 'Гроза', '.177', '18', 'red', 'Kalradia', '2021-03-03 19:10:52.480031', '17322', 'SMG', 1, 'BB,s', NULL, NULL, 1, 114, 'one mounth', 980);
INSERT INTO public.handgun(barrel_length, brand, caliber, capacity, color, country, crated_at, description, handgun_type, left_in_stock, model, modified_at, photo, price, total_length, warranty, weight) VALUES (14.8, 'Грозаr', '.177', '18', 'red', 'Kalradia', '2021-03-03 19:14:49.631239', '17323', 'SMG', 1, 'BB,s', NULL, NULL, 1, 114, 'one mounth', 980);
INSERT INTO public.handgun(barrel_length, brand, caliber, capacity, color, country, crated_at, description, handgun_type, left_in_stock, model, modified_at, photo, price, total_length, warranty, weight) VALUES (14.8, 'Гроза96', '.177', '18', 'red', 'Kalradia', '2021-03-03 19:15:10.003932', '17324', 'SMG', 1, 'BB', NULL, NULL, 1, 114, 'one mounth', 980);
