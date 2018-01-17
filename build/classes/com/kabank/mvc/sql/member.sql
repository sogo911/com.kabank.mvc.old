select * from tab;
select * from MEMBER;
select * from KAKAOBANK;
select * from member where id like 'sogo911';
update member set addr = '서울' where id = 'sogo911'
DELETE FROM Member WHERE id = '%s'
UPDATE MEMBER SET pass = '%s' WHERE id = '%s'
DROP TABLE KAKAOBANK;
create squence customNum start with 1000;  customNum 이 1씩 증가하는 코드
create table kakao(
	customNum number primary key,
	accountNum varchar2(20) not null,
	money varchar2(20) default 0, 디폴트 0 하면 기본값이 0원이라는뜻.
	id varchar2(20),
	foreign key(id) references member(id)
	on delete cascade
);

insert into KAKAOBANK(customNum,accountNum,money,id)
values(customer_num.nextval, '1234-5678', 0, skflsms5);