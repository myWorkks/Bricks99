drop schema if exists bricks99;





create schema bricks99;
use bricks99;
create table user_login(
user_id int primary key,
user_name varchar(30) not null,
password varchar(100) not null,
user_role enum('ADMIN','BUYER','SELLER') not null

);



create table address(
address_id int primary key auto_increment,
address_line_1 varchar(50),
address_line_2 varchar(50),
city varchar(25) not null,
state varchar(25) not null,
pincode varchar(6) not null
);
create table seller_registration(
registration_id int primary key auto_increment,
first_name varchar(30) not null,
last_name varchar(30) not null,
email_id varchar(30) unique not null,
contact varchar(10) unique not null,
address_id int   not null,
password varchar(10) not null,
status enum('APPROVED','PENDING','REJECTED'),
foreign key(address_id) references address(address_id)
);
