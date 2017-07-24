create 	table springboot.users(
username varchar(50) not null primary key,
password varchar(40) not null,
enabled boolean not null);

create table springboot.authorities(
	username varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users
    foreign key(username) references users(username));
create unique index ix_auth_username  on springboot.authorities(username,authority);

select * from springboot.users;

select * from springboot.authorities;


insert into role values(1,'ROLE_USER');
insert into role values(2,'ROLE_ADMIN');

insert into user values("1","1","naren@gmail.com","Narender","Singh");
insert into user values("2","1","laxmi@gmail.com","Laxmi","Shekhawat");

insert into user_role values(1,2);
insert into user_role values(2,1);