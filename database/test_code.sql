use joinme;

insert into member(member_id, member_password, member_name, nickname) values('id1','pw1','홍길동','홍');

select * from member;

update member
set member_password = 'pw2',
	member_name = '홍길순',
    nickname = '길',
    modify_date = now()
where member_id like 'id1';

select * from member;

# 1 row(s) affected, 1 warning(s): 1292 Incorrect date value: '2022-12-29 17:34:31' for column 'modify_date' at row 1 Rows matched: 1  Changed: 1  Warnings: 1