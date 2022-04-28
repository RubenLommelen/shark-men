SET search_path TO sharkmen;

create table POSTAL_CODE (
    ID integer NOT NULL,
    ZIP_CODE varchar(8) NOT NULL,
    CITY varchar(40) NOT NULL,
    CONSTRAINT PK_POSTAL_CODE primary key (ID)
);
CREATE SEQUENCE postal_code_seq start with 1 increment by 1;

create table ADDRESS (
    ID integer NOT NULL,
    STREET_NAME varchar(256) NOT NULL,
    STREET_NUMBER VARCHAR(10) NOT NULL,
    FK_POSTAL_CODE_ID integer NOT NULL,
    CONSTRAINT FK_POSTAL_CODE_ID foreign key (FK_POSTAL_CODE_ID) references POSTAL_CODE (ID),
    CONSTRAINT PK_ADDRESS primary key (ID)
);
CREATE SEQUENCE address_seq start with 1 increment by 1;

create table CONTACT_PERSON (
    ID integer NOT NULL,
    NAME varchar(256) NOT NULL,
    MOBILE_PHONE_NUMBER varchar(20),
    TELEPHONE_NUMBER varchar(20),
    EMAIL varchar(50) NOT NULL,
    FK_ADDRESS_ID integer NOT NULL,
    CONSTRAINT FK_CONTACT_ADDRESS_ID foreign key (FK_ADDRESS_ID) references ADDRESS (ID),
    CONSTRAINT PK_CONTACT_PERSON primary key (ID)
);
CREATE SEQUENCE contact_person_seq start with 1 increment by 1;

create table PARKING_LOT (
    ID integer NOT NULL,
    CATEGORY varchar(50) NOT NULL,
    NAME varchar(256) NOT NULL,
    CAPACITY integer NOT NULL,
    FK_CONTACT_PERSON_ID integer NOT NULL,
    FK_ADDRESS_ID integer NOT NULL,
    CONSTRAINT FK_PARKING_LOT_ADDRESS_ID foreign key (FK_ADDRESS_ID) references ADDRESS (ID),
    CONSTRAINT FK_CONTACT_PERSON_ID foreign key (FK_CONTACT_PERSON_ID) references CONTACT_PERSON (ID),
    CONSTRAINT PK_PARKING_LOT primary key (ID)
);
CREATE SEQUENCE parking_lot_seq start with 1 increment by 1;

