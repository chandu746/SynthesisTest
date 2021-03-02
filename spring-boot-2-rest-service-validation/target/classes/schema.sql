create table contact
(
   id integer not null,
   firstName varchar(75) not null,
   lastName varchar(50) not null,
   emailAddress varchar(255) not null,
   street varchar(55) not null,
   city varchar(30) not null,
   provinceState varchar(10) not null,
   country varchar(15) not null,
   primary key(id)
);