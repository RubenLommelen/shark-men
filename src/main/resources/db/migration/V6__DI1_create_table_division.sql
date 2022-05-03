create table DIVISION
(
    ID INTEGER NOT NULL PRIMARY KEY,
    NAME varchar(256) NOT NULL,
    ORIGINAL_NAME varchar(256) NOT NULL,
    DIRECTOR_NAME varchar(256) NOT NULL
);
create sequence division_seq start with 1 increment by 1;