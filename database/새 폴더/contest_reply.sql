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

desc contest_reply;
select * from contest_reply;