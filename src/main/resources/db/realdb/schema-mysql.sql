drop table if exists post, member, contest, recruitment, community, reply, scarp;

create table if not exists member(
	member_no int not null auto_increment,
	member_id varchar(40) not null unique,
    member_password char(40) not null,
    nickname char(20) unique not null unique,
	registration_date timestamp not null,
    modify_date timestamp not null,
    
    primary key(member_no)
);

create table if not exists post(
	post_no int not null auto_increment,
	member_no int not null,
    post_name varchar(20) not null,
    
    primary key(post_no, member_no),
	foreign key(member_no) references member(member_no)
    on update cascade on delete cascade
);

create table if not exists contest(
    post_no int not null,
    contest_no int not null,
	title varchar(60) not null,
    company_name varchar(60) not null,
    field varchar(100) not null,
    target_name varchar(40) not null,
    host_name varchar(40) not null,
    reward varchar(20) not null,
    start_date date not null,
    end_date date not null,
    contest_link varchar(100),
    registration_date timestamp not null,
    modify_date timestamp not null,
    
    primary key(contest_no, post_no),
    foreign key(post_no) references post(post_no)
    on update cascade,
	foreign key(contest_no) references post(post_no)
    on update cascade on delete cascade
);

create table if not exists recruitment(
    post_no int not null,
	contest_no int,
	title varchar(60) not null,
    textbox varchar(600) not null,
    region varchar(30) not null,
    join_link char(100),
    registration_date timestamp not null,
    modify_date timestamp not null,

    
    primary key(post_no),
    foreign key(post_no) references post(post_no)
    on update cascade,
	foreign key(contest_no) references contest(contest_no)
    on update cascade on delete cascade
);

create table if not exists community(
   	post_no int not null,
    title varchar(60) not null,
    textbox varchar(600) not null,
    category varchar(20) not null,
    registration_date timestamp not null,
    modify_date timestamp not null,
    
    primary key(post_no),
    foreign key(post_no) references post(post_no)
    on update cascade on delete cascade
);

create table if not exists reply (
	reply_no int not null auto_increment,
    post_no int not null,
	member_no int not null,
    textbox char(100) not null,
    registration_date timestamp not null,
    modify_date timestamp not null,

    
	primary key(reply_no),
    foreign key(post_no) references post(post_no)
    on update cascade on delete cascade, 
	foreign key(member_no) references member(member_no)
    on update cascade on delete cascade
);

create table if not exists scarp (
    post_no int not null,
    member_no int not null,
    
    foreign key(post_no) references post(post_no)
    on update cascade on delete cascade,
    foreign key(member_no) references member(member_no)
    on update cascade on delete cascade
);