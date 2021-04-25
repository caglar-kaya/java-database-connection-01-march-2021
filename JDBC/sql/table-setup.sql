create database if not exists ebookshop;

use ebookshop;

drop table if exists books;

create table books (
   id int,
   title varchar(50),
   author varchar(50),
   price float,
   qty int,
   primary key (id));
 
insert into books values (1, 'Java for dummies', 'Kevin Markham', 11.11, 11);
insert into books values (2, 'More Java for dummies', 'Jack Dunham', 22.22, 22);
insert into books values (3, 'More Java for more dummies', 'Mohammad Ali', 33.33, 33);
insert into books values (4, 'A Cup of Java', 'Dan Alton', 44.44, 44);
insert into books values (5, 'A Teaspoon of Java', 'Kevin Jones', 55.55, 55);

select * from books;

select author from books;

select * from books;

update books set price = price * 0.9 where id = 3 or id = 5;

delete from books where id >= 2 and id < 4;




