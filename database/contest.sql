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

desc contest;
select * from contest;