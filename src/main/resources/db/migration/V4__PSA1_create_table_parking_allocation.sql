SET
search_path TO sharkmen;
CREATE TABLE PARKING_ALLOCATION
(
    ID                   INTEGER                  NOT NULL,
    FK_MEMBER_ID         INTEGER                  NOT NULL,
    license_plate_number VARCHAR(56),
    fk_parking_lot_id    INTEGER                  NOT NULL,
    start_time           TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT PK_PARKING_ALLOCATION PRIMARY KEY (ID),
    CONSTRAINT FK_MEMBER FOREIGN KEY (FK_MEMBER_ID) REFERENCES MEMBER (ID),
    CONSTRAINT FK_PARKING_LOT FOREIGN KEY (fk_parking_lot_id) references PARKING_LOT (ID)

);
CREATE SEQUENCE PARKING_ALLOCATION_SEQ start with 1 increment by 1;