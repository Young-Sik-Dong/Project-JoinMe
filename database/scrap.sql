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

desc scarp;
select * from scarp;