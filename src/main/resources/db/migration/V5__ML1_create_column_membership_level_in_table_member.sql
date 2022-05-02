SET
search_path TO sharkmen;

ALTER TABLE member
ADD COLUMN membership_level varchar(50);

UPDATE member SET membership_level ='BRONZE';

ALTER TABLE member
    ALTER COLUMN membership_level SET NOT NULL;