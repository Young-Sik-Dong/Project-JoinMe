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

desc recruitment;
select * from recruitment;