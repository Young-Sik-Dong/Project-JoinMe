drop table if exists member;

create table member(
	member_id varchar(40) not null,
    member_password char(40) not null,
    member_name varchar(40) not null,
    nickname char(20) unique not null,
    registration_date date not null,
    modify_date date not null,
    primary key(member_id)
);

desc member;
select * from member;