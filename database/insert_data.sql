insert into member(member_id, member_password, nickname) 
	values	('id1', '1234', 'nickname1'),
			('id2', '1234', 'nickname2'),
			('id3', '1234', 'nickname3');

insert into post(post_name, member_no) 
	values	('CONTEST', 1),
			('CONTEST', 2),
			('CONTEST', 3),
			('CONTEST', 1),
			('CONTEST', 2),
			('CONTEST', 3),
			('CONTEST', 1),
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
			('COMMUNITY', 3),
			('COMMUNITY', 1),
			('COMMUNITY', 2),
			('COMMUNITY', 3),
			('COMMUNITY', 1),
			('COMMUNITY', 2),
			('COMMUNITY', 3);

insert into contest(post_no, contest_no, title, company_name, field, target_name, 
					host_name, reward, start_date, end_date, contest_link)
	values	(1, 1, '공모전1','A회사', 'F001', 'T001','H001', 'R001', '2023-01-01', '2023-02-11', 'link1'),
			(2, 2, '공모전2', 'B회사', 'F002', 'T002','H002', 'R002', '2023-01-02', '2023-02-12', 'link2'),
            (3, 3, '공모전3', 'C회사', 'F003', 'T003','H003', 'R003', '2023-01-03', '2023-02-13', 'link3'),
            (4, 4, '공모전4','D회사', 'F004', 'T004','H004', 'R004', '2023-01-04', '2023-02-14', 'link4'),
			(5, 5, '공모전5', 'E회사', 'F005', 'T005','H005', 'R005', '2023-01-05', '2023-02-15', 'link5'),
            (6, 6, '공모전6', 'F회사', 'F006', 'T006','H006', 'R006', '2023-01-06', '2023-02-16', 'link6'),
            (7, 7, '공모전7','G회사', 'F007', 'T001','H007', 'R007', '2023-01-07', '2023-02-17', 'link7'),
			(8, 8, '공모전8', 'H회사', 'F008', 'T002','H008', 'R008', '2023-01-08', '2023-02-18', 'link8'),
            (9, 9, '공모전9', 'I회사', 'F009', 'T003','H009', 'R009', '2023-01-09', '2023-02-19', 'link9'),
            (10, 10, '공모전10','J회사', 'F010', 'T004','H001', 'R001', '2023-01-10', '2023-02-20', 'link10'),
			(11, 11, '공모전11', 'K회사', 'F011', 'T005','H002', 'R002', '2023-01-11', '2023-02-21', 'link11'),
            (12, 12, '공모전12', 'L회사', 'F012', 'T006','H003', 'R003', '2023-01-12', '2023-02-22', 'link12');
     
insert into recruitment(post_no, contest_no, title, textbox, region, join_link)
	values	(13, 1, '모집글1', '본문1', 'R101', 'link1'),
			(14, 2, '모집글2', '본문2', 'R102', 'link2'),
            (15, 3, '모집글3', '본문3', 'R103', 'link3'),
            (16, 4, '모집글4', '본문4', 'R104', 'link4'),
			(17, 5, '모집글5', '본문5', 'R105', 'link5'),
            (18, 6, '모집글6', '본문6', 'R106', 'link6'),
            (19, 1, '모집글7', '본문7', 'R107', 'link7'),
			(20, 2, '모집글8', '본문8', 'R108', 'link8'),
            (21, 3, '모집글9', '본문9', 'R109', 'link9'),
            (22, 4, '모집글10', '본문10', 'R110', 'link10'),
			(23, 5, '모집글11', '본문11', 'R111', 'link11'),
            (24, 6, '모집글12', '본문12', 'R112', 'link12');
            
insert into community(post_no, title, textbox, category)
	values	(25, '게시글1', '본문1', 'C001'),
			(26, '게시글2', '본문2', 'C002'),
            (27, '게시글3', '본문3', 'C003'),
            (28, '게시글4', '본문4', 'C004'),
            (29, '게시글5', '본문5', 'C005'),
            (30, '게시글6', '본문6', 'C006'),
            (31, '게시글7', '본문7', 'C001'),
            (32, '게시글8', '본문8', 'C002'),
            (33, '게시글9', '본문9', 'C003'),
            (34, '게시글10', '본문10', 'C004'),
            (35, '게시글11', '본문11', 'C005'),
            (36, '게시글12', '본문12', 'C006'); 