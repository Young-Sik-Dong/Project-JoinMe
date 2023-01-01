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

desc community_reply;
select * from community_reply;