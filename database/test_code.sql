use joinme;

show tables;

select * from member where member_no = 1;
insert into member(member_id, member_password, nickname) 
	values	('id4', 'pw4', 'hi4');

show tables;

select * from member;

select * from post order by post_no desc;

update member
set 
member_password = "1357",
nickname = "nick5",
modify_date = current_date
where member_id = 'id4';

desc post;
desc contest;

delete from member
where member_id like 'id4';

delete from post
where post_no = 28;

select * from contest;

select * from post;
select * from recruitment;
select * from community;
select * from contest;
select * from reply;
select * from scarp;

SELECT 
	a.TABLE_NAME '테이블명',
	b.ORDINAL_POSITION '순번', 
	b.COLUMN_NAME '필드명', 
	b.DATA_TYPE 'DATA TYPE', 
	b.COLUMN_TYPE '데이터길이', 
	b.COLUMN_KEY 'KEY', 
	b.IS_NULLABLE 'NULL값여부', 
	b.EXTRA '자동순번', 
	b.COLUMN_DEFAULT '기본값', 
	b.COLUMN_COMMENT '필드설명' 
FROM information_schema.TABLES a 
	JOIN information_schema.COLUMNS b 
	ON a.TABLE_NAME = b.TABLE_NAME 
	AND a.TABLE_SCHEMA = b.TABLE_SCHEMA 
WHERE a.TABLE_SCHEMA = 'joinme' 
-- AND a.TABLE_NAME = '테이블명'   // 특정 테이블만 조회
ORDER BY a.TABLE_NAME, b.ORDINAL_POSITION;

