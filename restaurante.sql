create database restaurant;
use restaurant ;
create table users (user_id int auto_increment, username VARCHAR(50), password varchar(256), meal_status VARCHAR(3) default 'BLK', primary key(user_id), CONSTRAINT CHK_meal_status CHECK (meal_status in ('END','WRI','BLK') ));
CREATE table roles (role_id int auto_increment, name VARCHAR(50), user_id int, PRIMARY KEY (role_id), FOREIGN KEY(user_id) references users(user_id));
create table meals (meal_id int auto_increment, name VARCHAR(100), category varchar(100), origin varchar(100),image varchar(1000),url varchar(1000),primary key (meal_id));
create table users_meals (user_id int, meal_id int, primary key (user_id,meal_id), foreign key(user_id) references users(user_id), foreign key(meal_id) references meals(meal_id));
insert into users(username,password) values('user1','$2a$10$4DT94dgszrJ6bJKjrruw9O/UTUHUbPhihGrAjWAlh0Sn7rQP0U4.O');
insert into users(username,password) values('user2','$2a$10$en/1m7/bz0NFmE9aOafp7.QX5d2gdQ0JBDFX5ki/QX3TgjZW6eUGy');
insert into roles(name,user_id) values('ROLE_ADMIN',1);
insert into roles(name,user_id) values('ROLE_ADMIN',2);
INSERT INTO `restaurant`.`meals` (`meal_id`, `name`, `category`, `origin`, `image`, `url`) VALUES ('0', 'tamal', 'tamal', 'tamal', 'tamal', 'tamal');
INSERT INTO `restaurant`.`meals` (`meal_id`, `name`, `category`, `origin`, `image`, `url`) VALUES ('1', 'pache', 'pache', 'pache', 'pache', 'pache');

/*drop table meals;
drop table roles;
drop table users;
drop table users_meals;*/
select * from meals;
select count(*) from meals;
select count(*) from users_meals;
select * from users_meals;
select * from users;
select * from roles;

UPDATE `restaurant`.`users` SET `meal_status` = 'BLK' WHERE (`user_id` in ('1','2'));
delete from users_meals where user_id = 1;

select * from users u inner join users_meals um on um.user_id = u.user_id inner join meals m on m.meal_id = um.meal_id;