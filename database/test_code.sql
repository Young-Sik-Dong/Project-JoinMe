use joinme;

show tables;

select * from member where member_no = 1;
insert into member(member_id, member_password, nickname) 
	values	('id4', 'pw4', 'hi4');

select * from member;

select * from post order by post_no desc;

update member
set 
member_password = "1357",
nickname = "nick5",
modify_date = current_date
where member_id = 'id4';

delete from member
where member_id like 'id4';

select * from post;
select * from recruitment;
select * from community;
select * from contest;
select * from reply;
select * from scarp;