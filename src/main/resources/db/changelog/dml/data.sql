
--liquibase formatted sql

--changeset abinash:insert-employee
INSERT INTO employee_security.employee
(id, email_address, "password", is_active, authorities)
VALUES('962bd395-6ff9-4b54-b186-1b0760527577', 'abinash.sil@668@gmail.com', '{noop}@Binash668', true, 'admin;developer');




