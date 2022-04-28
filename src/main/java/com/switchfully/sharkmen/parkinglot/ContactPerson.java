package com.switchfully.sharkmen.parkinglot;

import com.switchfully.sharkmen.infrastructure.Address;

import javax.persistence.*;

@Entity
@Table(name = "CONTACT_PERSON")
public class ContactPerson {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "MOBILE_PONE_NUMBER")
    private String mobilePhoneNumber;

    @Column(name = "TELEPHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "EMAIL")
    private String email;

    @OneToOne
    @JoinColumn(name = "FK_ADDRESS_ID")
    private Address address;

    public ContactPerson() {
    }

    public ContactPerson(long id, String firstName, String lastName, String mobilePhoneNumber, String phoneNumber, String email, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }
}
