drop table if exists recruitment_reply;

create table recruitment_reply (
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

desc recruitment_reply;
select * from recruitment_reply;