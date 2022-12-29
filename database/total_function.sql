show databases;

drop database joinme;

create database joinme
character set = utf8mb4;

use joinme;

show tables;

drop table if exists post;

create table if not exists post(
	post_no varchar(4) not null,
    post_name varchar(8) not null,
	primary key(post_no)
);

insert into post values
('P001', '공모전'),
('P002', '모집'),
('P003', '커뮤니티');

drop table if exists member;

create table if not exists member(
	member_id varchar(40) not null,
    member_password char(40) not null,
    member_name varchar(40) not null,
    nickname char(20) unique not null,
    registration_date date not null,
    modify_date date not null default '9999-01-01',
    primary key(member_id)
);

drop table if exists contest;

create table if not exists contest(
	contest_no int not null auto_increment,
    post_no varchar(4) not null,
    member_id varchar(40) not null,
    title varchar(60) not null,
    company_name varchar(60) not null,
    field varchar(100) not null,
    target_name varchar(40) not null,
    host_name varchar(40) not null,
    reward varchar(20) not null,
    start_date date not null,
    end_date date not null,
    contest_link varchar(100),
    registration_date date not null,
    modify_date date not null,
    
    primary key(contest_no),
    foreign key(post_no) references post(post_no)
    on update cascade,
    foreign key(member_id) references member(member_id)
    on update cascade
);

drop table if exists recruitment;

create table if not exists recruitment(
	recruitment_no int not null auto_increment,
    post_no varchar(4) not null,
    member_id varchar(40) not null,
    contest_no int,
    title varchar(60) not null,
    region varchar(4) not null,
    contents varchar(400) not null,
    join_link char(100),
    registration_date date not null,
    modify_date date not null,
    
    primary key(recruitment_no),
    foreign key(post_no) references post(post_no)
    on update cascade,
    foreign key(member_id) references member(member_id)
    on update cascade,
    foreign key(contest_no) references contest(contest_no)
    on update cascade
);

drop table if exists community;

create table if not exists community(
	community_no int not null auto_increment,
    post_no varchar(4) not null,
    member_id varchar(40) not null,
    category varchar(8) not null,
    title varchar(60) not null,
    contents varchar(400) not null,
    registration_date date not null,
    modify_date date not null,
    
    primary key(community_no),
    foreign key(post_no) references post(post_no)
    on update cascade,
    foreign key(member_id) references member(member_id)
    on update cascade
);

drop table if exists community_reply;

create table if not exists community_reply (
	community_no int not null,
    member_id varchar(40) not null,
    contents char(100) not null,
    registration_date date not null,
    modify_date date not null,
    
    foreign key(community_no) references community(community_no)
    on update cascade,
    foreign key(member_id) references member(member_id)
    on update cascade 
);

drop table if exists contest_reply;

create table if not exists contest_reply (
	contest_no int not null,
    member_id varchar(40) not null,
    contents char(100) not null,
    registration_date date not null,
    modify_date date not null,
    
    foreign key(contest_no) references contest(contest_no)
    on update cascade,
    foreign key(member_id) references member(member_id)
    on update cascade 
);

drop table if exists recruitment_reply;

create table if not exists recruitment_reply (
	recruitment_no int not null,
    member_id varchar(40) not null,
    contents char(100) not null,
    registration_date date not null,
    modify_date date not null,
    
    foreign key(recruitment_no) references recruitment(recruitment_no)
    on update cascade,
    foreign key(member_id) references member(member_id)
    on update cascade 
);

drop table if exists scarp;

create table if not exists scarp (
	contest_no int,
    community_no int,
    recruitment_no int,
    member_id varchar(40) not null,
    
    foreign key(contest_no) references contest(contest_no)
    on update cascade,
    foreign key(community_no) references community(community_no)
    on update cascade,
    foreign key(recruitment_no) references recruitment(recruitment_no)
    on update cascade,
    foreign key(member_id) references member(member_id)
    on update cascade
);