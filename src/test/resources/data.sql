INSERT INTO license_plate(id,
                          license_plate_number,
                          country)
VALUES (1,
        'JA21HJH',
        'UK');

INSERT INTO postal_code(id,
                        zip_code,
                        city)
VALUES (1,
        'DH16',
        'devon');

INSERT INTO address(id,
                    street_name,
                    street_number,
                    fk_postal_code_id)
VALUES (1,
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
VALUES (1,
        'Ron',
        'Weasley',
        1,
        '123456789',
        'RonWeasley@hogwarts.com',
        1,
        TO_TIMESTAMP('1990-05-01', 'YYYY-MM-DD'));