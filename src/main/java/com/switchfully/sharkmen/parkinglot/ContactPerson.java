package com.switchfully.sharkmen.parkinglot;

import com.switchfully.sharkmen.infrastructure.Address;

public class ContactPerson {
    private final long id;
    private final String name;
    private String mobilePhoneNumber;
    private String phoneNumber;
    private String email;
    private final Address address;

    public ContactPerson(long id, String name, String mobilePhoneNumber, String phoneNumber, String email, Address address) {
        this.id = id;
        this.name = name;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }
}
