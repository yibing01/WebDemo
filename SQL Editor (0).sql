
    create table SCOTT.online_info(
       sessionId VARCHAR2(40) primary key not null,
       username VARCHAR2(40) not null,
       ip VARCHAR2(40) not null,
       pager VARCHAR2(40) not null,
       timer NUMBER(38) not null
    );