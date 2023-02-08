create database restaurant;
use restaurant ;
create table users (user_id int auto_increment, username VARCHAR(50), password varchar(256), primary key(user_id));
CREATE table roles (role_id int auto_increment, name VARCHAR(50), user_id int, PRIMARY KEY (role_id), FOREIGN KEY(user_id) references users(user_id)) ;
create table meals (meal_id int auto_increment, name VARCHAR(100), category varchar(100), origin varchar(100),image varchar(1000),url varchar(1000),primary key (meal_id), user_id int not null ,foreign key(user_id) references users (user_id));
insert into users(username,password) values('user1','$2a$10$4DT94dgszrJ6bJKjrruw9O/UTUHUbPhihGrAjWAlh0Sn7rQP0U4.O');
insert into users(username,password) values('user2','$2a$10$en/1m7/bz0NFmE9aOafp7.QX5d2gdQ0JBDFX5ki/QX3TgjZW6eUGy');
insert into roles(name,user_id) values('ROLE_ADMIN',1);
insert into roles(name,user_id) values('ROLE_ADMIN',2);
-- insert into meals(name,user_id) values ('test',1);

select * from meals ;