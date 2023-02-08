create database restaurant;
use restaurant ;
create table users (user_id int auto_increment, username VARCHAR(50), password varchar(256), meal_status VARCHAR(3) default 'BLK', primary key(user_id), CONSTRAINT CHK_meal_status CHECK (meal_status in ('END','WRI','BLK') ));
CREATE table roles (role_id int auto_increment, name VARCHAR(50), user_id int, PRIMARY KEY (role_id), FOREIGN KEY(user_id) references users(user_id));
create table meals (meal_id int auto_increment, name VARCHAR(100), category varchar(100), origin varchar(100),image varchar(1000),url varchar(1000),primary key (meal_id), user_id int not null ,foreign key(user_id) references users (user_id));
insert into users(username,password) values('user1','$2a$10$4DT94dgszrJ6bJKjrruw9O/UTUHUbPhihGrAjWAlh0Sn7rQP0U4.O');
insert into users(username,password) values('user2','$2a$10$en/1m7/bz0NFmE9aOafp7.QX5d2gdQ0JBDFX5ki/QX3TgjZW6eUGy');
insert into roles(name,user_id) values('ROLE_ADMIN',1);
insert into roles(name,user_id) values('ROLE_ADMIN',2);
INSERT INTO restaurant.meals (meal_id, name, category, origin, image, url, user_id) VALUES(1, 'nombre1', 'cat1', 'origin 1', 'image 1', 'url 1', 1);
INSERT INTO restaurant.meals (meal_id, name, category, origin, image, url, user_id) VALUES(2, 'nombre2', 'cat1', 'origin 1', 'image 1', 'url 1', 1);
INSERT INTO restaurant.meals (meal_id, name, category, origin, image, url, user_id) VALUES(3, 'nombre3', 'cat1', 'origin 1', 'image 1', 'url 1', 1);
-- insert into meals(name,user_id) values ('test',1);

select * from meals;
select * from users u ;
select * from users;
drop table meals;
drop table roles;
drop table users;

UPDATE `restaurant`.`users` SET `meal_status` = 'BLK' WHERE (`user_id` = '2');
