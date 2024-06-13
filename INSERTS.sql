-- Roles
# INSERT INTO roles(name) VALUES('ADMIN');
# INSERT INTO roles(name) VALUES('TEACHER');
# INSERT INTO roles(name) VALUES('STUDENT');
# INSERT INTO roles(name) VALUES('USER');
# INSERT INTO roles(name) VALUES('UNASSIGNED');

INSERT INTO roles (name) VALUES ('ROLE_ADMIN'),
                                ('ROLE_TEACHER'),
                                ('ROLE_STUDENT'),
                                ('ROLE_USER'),
                                ('ROLE_UNASSIGNED');



select * from users;
select * from user_roles;
select * from roles;