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

INSERT INTO user_roles (user_id, role_id) VALUES (1, 2);
UPDATE user_roles SET role_id = 2 WHERE user_id = 1;
DELETE FROM user_roles WHERE role_id = 4;


select * from agreement;
select * from rate;
select * from pack;

select * from subject;
select * from agreement_subject;

select * from subject;


DELETE FROM agreement WHERE id_agreement = 2;
DELETE FROM rate WHERE id_rate = 2;
DELETE FROM pack WHERE fk_rate = 2;

SET FOREIGN_KEY_CHECKS = 1;