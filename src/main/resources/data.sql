INSERT INTO role(id)VALUES ('ROLE_CLIENT');
INSERT INTO role(id)VALUES ('ROLE_MODERATOR');
INSERT INTO role(id)VALUES ('ROLE_ADMIN');

INSERT INTO client(id, email, first_name, last_name, password, phone_number, photo) VALUES ('8f42c6d8-5cba-4d2e-b73a-3c23c9a86165', 'user@mail.com', 'Simple', 'SUser', '$2a$10$5kjo5h7CXfub1qYeCTCxye0PsFUk3DxQg006nqjp8IZNS1GOIPYBu', '0932564759', NULL);
INSERT INTO client(id, email, first_name, last_name, password, phone_number, photo) VALUES ('ad1d9732-35e1-4b2f-9ba9-84b55bf5db21', 'moder@mail.com', 'Moder', 'MUser', '$2a$10$lqNK.aOKeLyZ0p0SuDmJvO3FrH1Y2OkFyLJve4fmkd2St3wookqVC', '0932564760', NULL);
INSERT INTO client(id, email, first_name, last_name, password, phone_number, photo) VALUES ('90e92136-044c-4ae7-b44a-68f7e450f696', 'admin@mail.com', 'Admin', 'Gangsta', '$2a$10$L2Tg2wXFvRKKGyGNBzwWVeLsG2zNqQGa5mCS7fgLNL1dSgV456i2K', '0932564777', NULL);

INSERT INTO client_role(client_id, role_id) VALUES ('8f42c6d8-5cba-4d2e-b73a-3c23c9a86165', 'ROLE_CLIENT');
INSERT INTO client_role(client_id, role_id) VALUES ('ad1d9732-35e1-4b2f-9ba9-84b55bf5db21', 'ROLE_MODERATOR');
INSERT INTO client_role(client_id, role_id) VALUES ('90e92136-044c-4ae7-b44a-68f7e450f696', 'ROLE_ADMIN');

INSERT INTO public.handgun(id, barrel_length, brand, caliber, capacity, color, country, crated_at, description, handgun_type, left_in_stock, model, modified_at, photo, price, total_length, warranty, weight)
                VALUES ('fb0a1fb0-9c22-463b-b94d-9531044fd4f4', 14.8, 'Гроза', '.177', '18', 'red', 'Kalradia', '2021-03-03 19:10:52.480031', '17322', 'SMG', 1, 'BB,s', NULL, NULL, 1, 114, 'one mounth', 980);
INSERT INTO public.handgun(id, barrel_length, brand, caliber, capacity, color, country, crated_at, description, handgun_type, left_in_stock, model, modified_at, photo, price, total_length, warranty, weight)
                VALUES ('e9204e80-8769-49e7-9d3f-4be947d934a9', 14.8, 'Грозаr', '.177', '18', 'red', 'Kalradia', '2021-03-03 19:14:49.631239', '17323', 'SMG', 1, 'BB,s', NULL, NULL, 1, 114, 'one mounth', 980);
INSERT INTO public.handgun(id, barrel_length, brand, caliber, capacity, color, country, crated_at, description, handgun_type, left_in_stock, model, modified_at, photo, price, total_length, warranty, weight)
                VALUES ('1df80b97-7448-45cd-a8d5-5e0f0aaeaa2f', 14.8, 'Гроза96', '.177', '18', 'red', 'Kalradia', '2021-03-03 19:15:10.003932', '17324', 'SMG', 1, 'BB', NULL, NULL, 1, 114, 'one mounth', 980);
