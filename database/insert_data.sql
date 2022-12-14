insert into member(member_id, member_password, nickname) 
	values	('id1', 'pw1', 'hi1'),
			('id2', 'pw2', 'hi2'),
			('id3', 'pw3', 'hi3');

insert into post(post_name, member_no) 
	values	('CONTEST', 1),
			('CONTEST', 2),
			('CONTEST', 3),
			('JOIN',  1),
			('JOIN', 2),
			('JOIN', 3),
			('COMMUNITY', 1),
			('COMMUNITY', 2),
			('COMMUNITY', 3);

insert into contest 
	values	(1, 1, '공모전 새글1','a', 'hi', 'hi','hi', '1억', '2022-01-06', '2022-02-10', 'link1'),
			(2, 2, '공모전 새글2', 'a', 'hi', 'hi','hi', '1억', '2022-01-06', '2022-02-10', 'link2'),
            (3, 3, '공모전 새글3', 'a', 'hi', 'hi','hi', '1억', '2022-01-06', '2022-02-10', 'link3');
     
insert into recruitment
	values	(4, 1, '모집글 새글1', '안녕하세요1', 'SEOUL', 'link1'),
			(5, 1, '모집글 새글2', '안녕하세요2', 'SEOUL', 'link1'),
            (6, 1, '모집글 새글3', '안녕하세요3', 'SEOUL', 'link1');
            
insert into community 
	values	(7, '커뮤니티 새글1', '안녕하세요1', 'STUDY'),
			(8, '커뮤니티 새글2', '안녕하세요2', 'STUDY'),
            (9, '커뮤니티 새글3', '안녕하세요3', 'STUDY'); 