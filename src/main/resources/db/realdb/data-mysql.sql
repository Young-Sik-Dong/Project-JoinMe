insert into member(member_id, member_password, nickname, registration_date, modify_date) 
	values	('id1', '1234', 'nickname1', '2023-01-01', '2023-01-12'),
			('id2', '1234', 'nickname2', '2023-01-01', '2023-01-12'),
			('id3', '1234', 'nickname3', '2023-01-01', '2023-01-12');

insert into post(post_name, member_no) 
	values	('CONTEST', 1),
			('CONTEST', 2),
			('CONTEST', 3),
			('CONTEST', 1),
			('CONTEST', 2),
			('CONTEST', 3),
			('JOIN', 1),
			('JOIN', 2),
			('JOIN', 3),
			('JOIN', 1),
			('JOIN', 2),
			('JOIN', 3),
			('COMMUNITY', 1),
			('COMMUNITY', 2),
			('COMMUNITY', 3),
			('COMMUNITY', 1),
			('COMMUNITY', 2),
			('COMMUNITY', 3);


insert into contest(post_no, contest_no, title, company_name, field, target_name, 
					host_name, reward, start_date, end_date, contest_link, registration_date, modify_date)
	values	(1, 1, '공모전1','A회사', 'F001', 'T001','H001', 'R001', '2023-01-01', '2023-02-11', 'link1', '2023-01-01', '2023-01-12'),
			(2, 2, '공모전2', 'B회사', 'F002', 'T002','H002', 'R002', '2023-01-02', '2023-02-12', 'link2', '2023-01-01', '2023-01-12'),
            (3, 3, '공모전3', 'C회사', 'F003', 'T003','H003', 'R003', '2023-01-03', '2023-02-13', 'link3', '2023-01-01', '2023-01-12'),
            (4, 4, '공모전4','D회사', 'F004', 'T004','H004', 'R004', '2023-01-04', '2023-02-14', 'link4', '2023-01-01', '2023-01-12'),
			(5, 5, '공모전5', 'E회사', 'F005', 'T005','H005', 'R005', '2023-01-05', '2023-02-15', 'link5', '2023-01-01', '2023-01-12'),
            (6, 6, '공모전6', 'F회사', 'F006', 'T006','H006', 'R006', '2023-01-06', '2023-02-16', 'link6', '2023-01-01', '2023-01-12');
     
insert into recruitment(post_no, contest_no, title, textbox, region, join_link, registration_date, modify_date)
	values	(7, 1, '모집글1', '본문1', 'R101', 'link1', '2023-01-01', '2023-01-12'),
			(8, 2, '모집글2', '본문2', 'R102', 'link2', '2023-01-01', '2023-01-12'),
            (9, 3, '모집글3', '본문3', 'R103', 'link3', '2023-01-01', '2023-01-12'),
            (10, 4, '모집글4', '본문4', 'R104', 'link4', '2023-01-01', '2023-01-12'),
			(11, 5, '모집글5', '본문5', 'R105', 'link5', '2023-01-01', '2023-01-12'),
            (12, 6, '모집글6', '본문6', 'R106', 'link6', '2023-01-01', '2023-01-12');
            
insert into community(post_no, title, textbox, category, registration_date, modify_date)
	values	(13, '게시글1', '본문1', 'C001', '2023-01-01', '2023-01-12'),
			(14, '게시글2', '본문2', 'C002', '2023-01-01', '2023-01-12'),
            (15, '게시글3', '본문3', 'C003', '2023-01-01', '2023-01-12'),
            (16, '게시글4', '본문4', 'C004', '2023-01-01', '2023-01-12'),
            (17, '게시글5', '본문5', 'C005', '2023-01-01', '2023-01-12'),
            (18, '게시글6', '본문6', 'C006', '2023-01-01', '2023-01-12');
