# DB 생성 및 기본 data 입력

create table board(
num NUMBER(5) PRIMARY KEY,
pass VARCHAR2(30),
name VARCHAR2(30),
email VARCHAR2(30),
title VARCHAR2(50),
content VARCHAR2(1000),
readcount NUMBER(4) DEFAULT 0,
writedate DATE DEFAULT sysdate
);

create sequence board_seq start with 1 increment by 1;

insert into board(num, name, email, pass, title, content) 
values(board_seq.nextval, '성윤정','pinksung@nate.com','1234','첫방문','반갑습니다.');

insert into board(num, name, email, pass, title, content) 
values(board_seq.nextval, '성윤정','pinksung@nate.com','1234','김밥','맛있어요.');

insert into board(num, name, email, pass, title, content) 
values(board_seq.nextval, '전수빈','raccon@nate.com','3333','고등애','일식입니다.');

insert into board(num, name, email, pass, title, content) 
values(board_seq.nextval, '전원지','one@nate.com','1111','갯골마을','돼지삼겹살이 맛있습니다.');
commit;


#connection pool config
-server 적용 <Resource name="jdbc/myoracle" auth="Container"type="javax.sql.DataSource" 
driverClassName="oracle.jdbc.OracleDriver"url="jdbc:oracle:thin:@127.0.0.1:1521:XE"username="scott" password="tiger" maxTotal="20" maxIdle="10"maxWaitMillis="-1"/>
•01_dbcp.jsp 적용 Context initContext = new InitialContext(); Context envContext = (Context)initContext.lookup("java:/comp/env"); DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle"); Connection conn = ds.getConnection(); System.out.println("conn: " + conn);
