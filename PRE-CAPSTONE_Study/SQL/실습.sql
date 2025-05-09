create database jdbc_db;

use jdbc_db; #해당 db를 활성화 할 때 사용하는 코드

show databases; #테이블을 보는 코드

drop database jdbc_db; # 테이블 삭제 

create table mem (
num int not null,
id char(15) not null,
name char(10) not null,
sex char(1),
post_num char(8),
address char(80),
tel char(20),
age int,
primary key(num) # 주 키
);


create table friend (
num int not null,
name char(10),
address char(80),
tel char(20),
primary key(num));

desc mem;
desc freind;


drop table friend;


#테이블에 데이터 삽입하기. -> 드래그 하지말고 줄 제일 처음을 클릭 한 후 하나씩 실행해야 하는 것 같다.
insert into mem values (1, 'yjhwang', '황영주', 'M', '100-011','서울시 중구 충무로1가', '234-8879', 35);
insert into mem values (2, 'khshul', '설기형', 'M', '607-010','부산시 동래구 명륜동', '764-3784', 33);
insert into mem values (3, 'chpark', '박철호', 'M', '503-200','광주시 남구 지석동', '298-9730', 34);

show tables; 


select * from mem; # 테이블 명시 

# import 전까지 코드

#실습(레코드 추가) 28p
select * from book;
select id, name, address from mem;
select distinct name from mem;
desc book;

insert into book values(11,'스포츠 의학','한솔의학서적',90000);
insert into book values(12,'스포츠 의학','한솔의학서적',null);

# 실습(레코드 검색 명령) 33p

select bookname, price from book;
select price, bookname from book;
select bookid,bookname,publisher,price from book;
select publisher from book;
select distinct publisher from book;

select id, name, address from mem where name='김수련';
select id, name, address, tel, sex from mem where sex='W';
select * from mem where age>=50;
select name, id, address, post_num from mem where age>=20 and age<30;
select id, address, post_num, age from mem where name = '김진모';
select name, address, age from mem where age>=40 and age < 50 and sex ='M';

select name, address, age from mem where name not in ('이상훈');
select name, address, age from mem where name != '이상훈';

select name, address, age from mem where name != '신수진';

#실습 (레코드 검색 명령) 41p

select * from book where price<20000;
select * from book where price<=20000 and price >=10000;
select * from book where publisher='대한미디어' or publisher = '굿스포츠';
select * from book where publisher not in ('대한미디어') and publisher not in ('굿스포츠');

# Auto Increament

create table friend_auto (
	num int not null AUTO_INCREMENT,
    name char(10),
    address char(80),
    tel char(20),
    primary key(num));

insert into friend_auto values (null, 'tom', 'NY', '100-011');
insert into friend_auto values (null, 'mary', 'LA', '200-201');

select * from friend_auto;

#레코드 검색 명령

select name, address, tel from mem where name like '김%';
select name, address from mem where address like '서울%';
select name, address, sex from mem where address like '부산%' and sex='W';
select name, id from mem where name like '_용_%';
select name, id, address, tel from mem where address like '광주%' and name like '김%';

# 실습 (레코드 검색 명령) 48p

select bookname, publisher from book where bookname like '축구의 역사';
select bookname,publisher from book where bookname like '축구%';
select bookid, bookname, publisher, price from book where bookname like '_구%';
select bookid, bookname, publisher, price from book where price >=20000 and bookname like '축구%';

# 레코드 정렬 명령

#오름차순
select age, id, name ,tel from mem order by age;

# 나이 순으로 정렬하고, 나이가 같으면 id 순으로 정렬한다.
select age,id,name,tel from mem order by age, id;

#내림차순 +decs
select age, name, address from mem where address like '서울%' order by age desc;

#실습(레코드 정렬 명령) 53p
select * from book order by bookname;
select * from book order by price, bookname;
select * from book order by price desc, publisher;

#집계 함수

select sum(age) from mem;

# 모두 더한 값을 sum_age 에 저장.
select sum(age) as sum_age from mem;

select count(*) as count from mem where age>=20;
select avg(age) as avg_age from mem where age >= 20;

select sum(saleprice) as total_price from orders;
select sum(saleprice) as Total, avg(saleprice) as Average, min(saleprice) as Minimum, max(saleprice) as Maximum from orders; 
select count(*) as COUNT from orders;

# 레코드 수정
select * from mem where id like 'yjh%';
update mem set tel='123-4567' where id like 'yjh%';

update mem set age=27 where name='신수진';
select name, age from mem where name='신수진';
select name from mem;

delete from mem where name ='김길수';
select * from mem where name= '김길수';