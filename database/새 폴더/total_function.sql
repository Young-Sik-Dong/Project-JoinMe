drop database if exists joinme;

create database joinme
character set = utf8mb4;

use joinme;

drop table if exists post, member, contest, recruitment, community, 
			community_reply, contest_reply, recruitment_reply, scarp;

create table if not exists member(
	member_no int not null auto_increment,
	member_id varchar(40) not null,
    member_password char(40) not null,
    member_name varchar(40) not null,
    nickname char(20) unique not null,
    
    primary key(member_no)
);

create table if not exists post(
	post_no int not null,
    post_name varchar(20) not null,
    title varchar(60) not null,
    textbox varchar(600) not null,
    registration_date date not null default (current_date),
    modify_date date not null default '9999-01-01',
	primary key(post_no)
);

create table if not exists contest(
    post_no int not null,
    post_name varchar(8) not null,
    member_no int not null,
    company_name varchar(60) not null,
    field varchar(100) not null,
    target_name varchar(40) not null,
    host_name varchar(40) not null,
    reward varchar(20) not null,
    start_date date not null,
    end_date date not null,
    contest_link varchar(100),
    
    primary key(post_no),
    foreign key(post_no) references post(post_no)
    on update cascade,
	foreign key(post_name) references post(post_name)
    on update cascade,
    foreign key(member_no) references member(member_no)
    on update cascade
);

create table if not exists recruitment(
    post_no int not null,
	contest_no int,
	member_no int not null,
    region varchar(4) not null,
    join_link char(100),
    
    primary key(post_no),
    foreign key(post_no) references post(post_no)
    on update cascade,
	foreign key(contest_no) references post(post_no)
    on update cascade,
	foreign key(post_name) references post(post_name)
    on update cascade,
    foreign key(member_no) references member(member_no)
    on update cascade
);

create table if not exists community(
   	post_no int not null,
    post_name varchar(20) not null,
	member_no int not null,
    category varchar(20) not null,
    
    primary key(post_no),
    foreign key(post_no) references post(post_no)
    on update cascade,
	foreign key(post_name) references post(post_name)
    on update cascade,
    foreign key(member_no) references member(member_no)
    on update cascade
);

create table if not exists reply (
	contest_no int not null,
	member_no int not null,
    contents char(100) not null,
    registration_date date not null default (current_date),
    modify_date date not null default '9999-01-01',
    
    foreign key(contest_no) references contest(contest_no)
    on update cascade,
    foreign key(member_no) references member(member_no)
    on update cascade 
);

create table if not exists scarp (
    post_no int not null,
    member_no int not null,
    
    foreign key(post_no) references post(post_no)
    on update cascade,
    foreign key(member_no) references member(member_no)
    on update cascade
);

insert into post values
('P001', '공모전'),
('P002', '모집'),
('P003', '커뮤니티');