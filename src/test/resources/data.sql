INSERT INTO license_plate(id,
                          license_plate_number,
                          country)
VALUES (nextval('license_plate_seq'),
        'JA21HJH',
        'UK');

INSERT INTO postal_code(id,
                        zip_code,
                        city)
VALUES (nextval('postal_code_seq'),
        'DH16',
        'devon');

INSERT INTO address(id,
                    street_name,
                    street_number,
                    fk_postal_code_id)
VALUES (nextval('address_seq'),
        'The Burrow',
        '1',
        1);


INSERT INTO member(id,
                   firstname,
                   lastname,
                   fk_address_id,
                   phone_number,
                   email_address,
                   fk_license_plate_id,
                   registration_date)
VALUES (nextval('member_seq'),
        'Ron',
        'Weasley',
        1,
        '123456789',
        'RonWeasley@hogwarts.com',
        1,
        TO_TIMESTAMP('1990-05-01', 'YYYY-MM-DD'));

insert into contact_person(id,
                           first_name,
                           last_name,
                           mobile_phone_number,
                           telephone_number,
                           email,
                           fk_address_id)
values (nextval('contact_person_seq'),
        'Albus',
        'Dumbledore',
        '025412',
        '212404',
        'albus.dumbledore@hogwarts.uk',
        1);

insert into parking_lot(id,
                 category,
                 name,
                 capacity,
                 fk_contact_person_id,
                 fk_address_id)
values (nextval('parking_lot_seq'),
        'UNDERGROUND_BUILDING',
        'Parkshark',
        80,
        1,
        1);
