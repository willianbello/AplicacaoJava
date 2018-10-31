create table party (
  id integer identity primary key,
  code varchar(10) not null,
  name varchar(255) not null,
  number integer not null
);
