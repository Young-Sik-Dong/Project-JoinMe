drop table if exists post;

create table if not exists post(
	post_no varchar(4) not null,
    post_name varchar(8) not null,
	primary key(post_no)
);

insert into post values
('P001', '공모전'),
('P002', '모집'),
('P003', '커뮤니티');

desc post;
select * from post;