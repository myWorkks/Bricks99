drop schema if exists bricks99;
create schema bricks99;
use bricks99;
create table user_login(
user_id int primary key,
user_name varchar(30) not null,
password varchar(100) not null,
user_role enum('ADMIN','BUYER','SELLER') not null

);
