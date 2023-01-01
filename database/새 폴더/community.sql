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

desc community;
select * from community;