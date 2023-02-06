create database product_management;
use product_management;

create table `product`(
id int primary key,
name varchar(45),
price double,
note varchar(45),
producer varchar(45));

insert into `product` VALUE 
(4, "Corola Altis", 850000000, "Ô tô", "Toyota"),
(5, "Civic", 560000000, "Ô tô", "Honda"),
(6, "C300", 1400000000, "Ô tô", "Mercedes"),
(7, "LX570", 8300000000, "Ô tô", "LEXUS");

drop database product_management;