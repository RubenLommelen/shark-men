package com.switchfully.sharkmen.parkinglot;

import com.switchfully.sharkmen.infrastructure.Address;

public class ContactPerson {
    private final long id;
    private final String firstName;
    private final String lastName;
    private String mobilePhoneNumber;
    private String phoneNumber;
    private String email;
    private final Address address;

    public ContactPerson(long id, String firstName, String lastName, String mobilePhoneNumber, String phoneNumber, String email, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }
}
