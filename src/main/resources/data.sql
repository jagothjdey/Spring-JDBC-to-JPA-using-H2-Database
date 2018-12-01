create table person
(
  id integer not null,
  name varchar(255) not null,
  location varchar(255),
  birth_date timestamp,
  primary key(id)
);

insert into person(id,name,location,birth_date) values(1,'Jagoth1','Bangladesh1',sysdate());
insert into person(id,name,location,birth_date) values(2,'Jagoth2','Bangladesh2',sysdate());
insert into person(id,name,location,birth_date) values(3,'Jagoth3','Bangladesh3',sysdate());
insert into person(id,name,location,birth_date) values(4,'Jagoth4','Bangladesh4',sysdate());
insert into person(id,name,location,birth_date) values(5,'Jagoth5','Bangladesh5',sysdate());