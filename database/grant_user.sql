select host, user from mysql.user;

drop user 'dong'@'localhost';

## 계정 생성
create user 'dong'@'localhost' identified by 'dong1234';

## 계정 확인
select host, user from mysql.user;

## 권한 확인
show grants for 'dong'@'localhost';

## 권한 설정
GRANT ALL PRIVILEGES ON joinme.* TO 'dong'@'localhost';

## 권한 확인
show grants for 'dong'@'localhost';

## 권한 테스트
select * from community;